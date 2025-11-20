package hr.foi.air.ws.network

import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.ws.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductsService {
    @GET("products")
    fun getProducts(@Header("Authorization") authHeader: String): Call<SuccessfulResponseBody<Product>>
}