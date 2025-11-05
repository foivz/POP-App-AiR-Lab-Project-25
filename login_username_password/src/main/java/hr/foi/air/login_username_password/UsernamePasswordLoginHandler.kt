package hr.foi.air.login_username_password

import hr.foi.air.core.LoginHandler
import hr.foi.air.core.LoginOutcomeListener
import hr.foi.air.core.LoginToken

class UsernamePasswordLoginHandler : LoginHandler {
    override fun handleLogin(
        loginToken: LoginToken,
        loginListener: LoginOutcomeListener
    ) {
        if (loginToken !is UsernamePasswordLoginToken) {
            throw IllegalArgumentException("Must receive UsernamePasswordLoginToken instance for 'loginToken'!")
        }

        val authorizers = loginToken.getAuthorizers()
        val username = authorizers["username"]
        val password = authorizers["password"]

        if (username == "ihorvat" && password == "test123") {
            loginListener.onSuccessfulLogin("ihorvat")
        } else {
            loginListener.onFailedLogin("Wrong mock credentials entered. The correct combination is 'ihorvat'-'test123'!")
        }
    }
}