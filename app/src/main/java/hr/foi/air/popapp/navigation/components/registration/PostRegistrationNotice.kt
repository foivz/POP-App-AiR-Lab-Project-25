package hr.foi.air.popapp.navigation.components.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.components.StyledButton

@Composable
fun PostRegistrationNotice(
    newUsername: String,
    onNoticeUnderstood: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome '$newUsername'. Please wait until course teacher accepts your account.")
        StyledButton(
            label = "I understand",
            onClick = onNoticeUnderstood
        )
    }
}




