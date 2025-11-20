package hr.foi.air.login_username_password

import hr.foi.air.core.LoginHandler
import hr.foi.air.core.LoginOutcomeListener
import hr.foi.air.core.LoginToken
import hr.foi.air.core.LoginUserData
import hr.foi.air.core.network.ResponseListener
import hr.foi.air.core.network.models.ErrorResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.LoggedInUserData
import hr.foi.air.ws.models.LoginBody
import hr.foi.air.ws.request_handlers.LoginRequestHandler

class UsernamePasswordLoginHandler : LoginHandler {
    override fun handleLogin(
        loginToken: LoginToken,
        loginListener: LoginOutcomeListener
    ) {
        if (loginToken !is UsernamePasswordLoginToken) {
            throw IllegalArgumentException("Must receive UsernamePasswordLoginToken instance for 'loginToken'!")
        }

        val authorizers = loginToken.getAuthorizers()
        val username = authorizers["username"]!!
        val password = authorizers["password"]!!

        val loginRequestHandler = LoginRequestHandler(LoginBody(username, password))

        loginRequestHandler.sendRequest(object : ResponseListener<LoggedInUserData> {
            override fun onNetworkFailure(t: Throwable) {
                loginListener.onFailedLogin(t.message ?: "Could not connect to network.")
            }

            override fun onErrorResponse(response: ErrorResponseBody) {
                loginListener.onFailedLogin(response.message)
            }

            override fun onSuccessfulResponse(response: SuccessfulResponseBody<LoggedInUserData>) {
                val loginUserData = response.data[0]

                loginListener.onSuccessfulLogin(LoginUserData(
                    userId = loginUserData.id!!,
                    username = loginUserData.username!!,
                    firstName = loginUserData.firstName!!,
                    lastName = loginUserData.lastName!!,
                    role = loginUserData.role!!,
                    isAccepted = loginUserData.isAccepted!!,
                    storeId = loginUserData.store?.storeId,
                    storeName = loginUserData.store?.storeName,
                    jwt = loginUserData.tokenPair!!.accessToken!!,
                    refreshToken = loginUserData.tokenPair!!.refreshToken.token!!
                ))
            }

        })
    }
}