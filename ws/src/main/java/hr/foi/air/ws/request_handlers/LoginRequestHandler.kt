package hr.foi.air.ws.request_handlers

import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.LoggedInUserData
import hr.foi.air.ws.models.LoginBody
import hr.foi.air.ws.network.NetworkService
import retrofit2.Call

class LoginRequestHandler(private val requestBody: LoginBody) :
    TemplateRequestHandler<LoggedInUserData>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<LoggedInUserData>> {
        val service = NetworkService.authService
        return service.loginUser(requestBody)
    }
}