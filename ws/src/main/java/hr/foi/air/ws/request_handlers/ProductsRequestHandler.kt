package hr.foi.air.ws.request_handlers

import com.google.gson.Gson
import hr.foi.air.core.network.RequestHandler
import hr.foi.air.core.network.ResponseListener
import hr.foi.air.core.network.models.ErrorResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.Product
import hr.foi.air.ws.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRequestHandler(private val jwt: String) : RequestHandler<Array<Product>> {
    override fun sendRequest(responseListener: ResponseListener<Array<Product>>) {
        val service = NetworkService.productsService
        val serviceCall = service.getProducts("Bearer $jwt")

        serviceCall.enqueue(object : Callback<SuccessfulResponseBody<Array<Product>>> {
            override fun onResponse(
                call: Call<SuccessfulResponseBody<Array<Product>>>,
                response: Response<SuccessfulResponseBody<Array<Product>>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body() as SuccessfulResponseBody<Array<Product>>
                    responseListener.onSuccessfulResponse(body)
                } else {
                    val errorResponse = Gson().fromJson(response.errorBody()?.string(),
                        ErrorResponseBody::class.java)
                    responseListener.onErrorResponse(errorResponse)
                }
            }
            override fun onFailure(call: Call<SuccessfulResponseBody<Array<Product>>>, t:
            Throwable) {
                responseListener.onNetworkFailure(t)
            }
        })
    }
}
