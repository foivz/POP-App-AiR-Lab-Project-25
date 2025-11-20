package hr.foi.air.ws.network

import hr.foi.air.core.network.models.ResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.LoggedInUserData
import hr.foi.air.ws.models.LoginBody
import hr.foi.air.ws.models.RegistrationBody
import hr.foi.air.ws.models.responses.RegisteredUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/register")
    fun registerUser(@Body registerBody: RegistrationBody): Call<SuccessfulResponseBody<RegisteredUser>>

    @POST("auth/login")
    fun loginUser(@Body loginBody: LoginBody): Call<SuccessfulResponseBody<LoggedInUserData>>
}