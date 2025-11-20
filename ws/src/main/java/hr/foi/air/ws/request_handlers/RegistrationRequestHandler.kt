package hr.foi.air.ws.request_handlers

import com.google.gson.Gson
import hr.foi.air.core.network.RequestHandler
import hr.foi.air.core.network.ResponseListener
import hr.foi.air.core.network.models.ErrorResponseBody
import hr.foi.air.core.network.models.ResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.RegistrationBody
import hr.foi.air.ws.models.responses.RegisteredUser
import hr.foi.air.ws.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationRequestHandler(private val requestBody: RegistrationBody) : RequestHandler<RegisteredUser> {
    override fun sendRequest(responseListener: ResponseListener<RegisteredUser>) {
        val service = NetworkService.authService
        val serviceCall = service.registerUser(requestBody)
        serviceCall.enqueue(object : Callback<SuccessfulResponseBody<RegisteredUser>> {
            override fun onResponse(call: Call<SuccessfulResponseBody<RegisteredUser>>, response: Response<SuccessfulResponseBody<RegisteredUser>>) {
                if (response.isSuccessful) {
                    val body = response.body() as SuccessfulResponseBody<RegisteredUser>
                    responseListener.onSuccessfulResponse(body)
                } else {
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponseBody::class.java)
                    responseListener.onErrorResponse(errorResponse)
                }
            }

            override fun onFailure(call: Call<SuccessfulResponseBody<RegisteredUser>>, t: Throwable) {
                responseListener.onNetworkFailure(t)
            }
        })
    }
}