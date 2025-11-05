package hr.foi.air.core

interface LoginHandler {
    fun handleLogin(loginToken: LoginToken, loginListener: LoginOutcomeListener)
}