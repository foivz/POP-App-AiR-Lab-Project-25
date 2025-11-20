package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.core.network.ResponseListener
import hr.foi.air.core.network.models.ErrorResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.context.Auth
import hr.foi.air.ws.models.Product
import hr.foi.air.ws.request_handlers.ProductsRequestHandler

class ProductsViewModel : ViewModel() {
    private val _products: MutableLiveData<List<Product>>
            = MutableLiveData(mutableListOf())
    val products: LiveData<List<Product>> = _products

    init {
        val productsRequestHandler = ProductsRequestHandler(Auth.loggedInUserData!!.jwt)

        productsRequestHandler.sendRequest(object : ResponseListener<Product> {
            override fun onNetworkFailure(t: Throwable) {

            }

            override fun onErrorResponse(response: ErrorResponseBody) {

            }

            override fun onSuccessfulResponse(response: SuccessfulResponseBody<Product>) {
                _products.value = response.data.toList()
            }
        })
    }
}