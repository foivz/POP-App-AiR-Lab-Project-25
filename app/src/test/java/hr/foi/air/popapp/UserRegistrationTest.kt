package hr.foi.air.popapp

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.junit.Test

import org.junit.Assert.*

class UserRegistrationTest {
    @Test
    fun registrationRouteIsAccessible() {
        val url = "http://ase.foi.hr/pop/api/v2/auth/register"

        val client = OkHttpClient()
        val json = "{\"first_name\":\"Ivan\",\"last_name\":\"Horvat\",\"username\":\"ihorvat\",\"email\":\"ihorvat@foi.hr\",\"password\":\"test123\",\"role\":\"buyer\"}"
        val body: RequestBody = json.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).execute().use { res ->
            assertTrue(res.body.string().contains("Could not register user!"))
        }
    }
}