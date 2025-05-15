package com.sddrozdov.newsappcompose.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sddrozdov.newsappcompose.R
import com.sddrozdov.newsappcompose.ui.component.StyledButton
import com.sddrozdov.newsappcompose.ui.navigation.Screen
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenEvent
import com.sddrozdov.newsappcompose.ui.screen.state.LoginScreenState
import com.sddrozdov.newsappcompose.ui.screen.viewmodel.LoginScreenViewModel
import com.sddrozdov.newsappcompose.util.Result

@Composable
fun LoginScreen(
    onNavigateTo: (Screen) -> Unit
) {
    val viewModel = viewModel<LoginScreenViewModel>()

    val context = LocalContext.current
    LaunchedEffect(viewModel.state.loginResult) {
        viewModel.state.loginResult?.let { loginResult ->
            when (loginResult) {
                is Result.Success -> {
                    onNavigateTo(Screen.Main)
                }
                is Result.Failure -> {
                    Toast.makeText(
                        context,
                        loginResult.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    LoginView(
        state = viewModel.state,
        onNavigateTo = onNavigateTo,
        onEvent = viewModel::onEvent
    )
}


@Composable
fun LoginView(
    onNavigateTo: (Screen) -> Unit = {},
    state: LoginScreenState = LoginScreenState(),
    onEvent: (LoginScreenEvent) -> Unit = {}
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
        Image(
            painter = painterResource(id = R.drawable.log_image_news),
            contentDescription = "Login image news",
            modifier = Modifier.padding(top = 15.dp)
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 15.dp),
            value = state.email,
            onValueChange = {
                onEvent(LoginScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = ""
                )
            },
            placeholder = {
                Text(text = stringResource(R.string.enter_email))
            }
        )
        OutlinedTextField(
            value = state.password,
            onValueChange = {
                onEvent(LoginScreenEvent.PasswordUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = ""
                )
            }, modifier = Modifier.padding(top = 15.dp),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = stringResource(R.string.enter_password))
            }
        )
        StyledButton(
            onClick = { onEvent(LoginScreenEvent.LoginBtnClicked) },
            modifier = Modifier.padding(top = 35.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                fontSize = 21.sp
            )
        }
        Text(
            text = stringResource(id = R.string.no_account),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    onNavigateTo(Screen.Register)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginView()
}