package hr.foi.air.core.network

import hr.foi.air.core.network.models.ErrorResponseBody
import hr.foi.air.core.network.models.SuccessfulResponseBody

interface ResponseListener<T> {
    fun onNetworkFailure(t: Throwable)
    fun onErrorResponse(response: ErrorResponseBody)
    fun onSuccessfulResponse(response: SuccessfulResponseBody<T>)
}