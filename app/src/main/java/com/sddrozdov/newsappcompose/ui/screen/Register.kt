package com.sddrozdov.newsappcompose.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sddrozdov.newsappcompose.R
import com.sddrozdov.newsappcompose.ui.navigation.Screen
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenEvent

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    RegisterView(onNavigateTo = onNavigateTo)
}

@Composable
fun RegisterView(
    onNavigateTo: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 110.dp)
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 15.dp),
            value = state.email,
            onValueChange = {
                onEvent(LoginScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Person),
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(text = stringResource(R.string.enter_username))
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterView()
}