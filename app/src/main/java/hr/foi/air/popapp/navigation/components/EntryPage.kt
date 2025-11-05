package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.R
import hr.foi.air.popapp.ui.theme.Typography

@Composable
fun EntryPage(
    onLoginButtonClick: () -> Unit,
    onRegistrationButtonCLick: () -> Unit
) {
    Scaffold(
        topBar = {
            Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
            }
        },
        bottomBar = {
            Text(
                text = "Copyright FOI 2025",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(vertical = 16.dp).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Welcome to POP App",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Button(
                onClick = onLoginButtonClick,
                modifier = Modifier.fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Login", color = Color.White)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(0.47f),
                    thickness = 2.dp,
                    color = Color.LightGray
                )
                Text("OR")
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 2.dp,
                    color = Color.LightGray
                )
            }

            Button(
                onClick = onRegistrationButtonCLick,
                modifier = Modifier.fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}


@Preview
@Composable
fun EntryPagePreview() {
    EntryPage({}, {})
}







