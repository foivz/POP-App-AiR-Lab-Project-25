package hr.foi.air.login_username_password

import hr.foi.air.core.LoginToken

class UsernamePasswordLoginToken : LoginToken {
    private val authorizers = emptyMap<String, String>()

    override fun getAuthorizers(): Map<String, String> {
        return authorizers
    }
}