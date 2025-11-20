package hr.foi.air.core

data class LoginUserData(
    val userId: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    val isAccepted: Boolean,
    val storeId: Int?,
    val storeName: String?,
    val jwt: String,
    val refreshToken: String
)
