package hr.foi.air.core

interface LoginOutcomeListener {
    fun onSuccessfulLogin(username: String)
    fun onFailedLogin(reason: String)
}