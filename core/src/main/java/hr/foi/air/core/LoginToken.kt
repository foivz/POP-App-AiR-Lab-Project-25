package hr.foi.air.core

interface LoginToken {
    fun getAuthorizers(): Map<String, String>
}