package com.sddrozdov.newsappcompose.ui.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sddrozdov.newsappcompose.R
import com.sddrozdov.newsappcompose.ui.component.StyledButton
import com.sddrozdov.newsappcompose.ui.navigation.Screen
import com.sddrozdov.newsappcompose.ui.screen.state.RegisterScreenEvent
import com.sddrozdov.newsappcompose.ui.screen.state.RegisterScreenState
import com.sddrozdov.newsappcompose.ui.screen.viewmodel.RegisterScreenViewModel

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    val viewModel = viewModel<RegisterScreenViewModel>()
    RegisterView(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        onNavigateTo = onNavigateTo)
}

@Composable
fun RegisterView(
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {},
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
            value = state.username,
            onValueChange = {
                onEvent(RegisterScreenEvent.UsernameUpdated(it))
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
        OutlinedTextField(
            modifier = Modifier.padding(top = 15.dp),
            value = state.email,
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
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
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
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
            onClick = {},
            modifier = Modifier.padding(top = 35.dp)
        ) {
            Text(
                text = stringResource(R.string.register),
                fontSize = 21.sp
            )
        }
        Text(
            text = stringResource(id = R.string.already_have_an_acc),
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
fun RegisterScreenPreview() {
    RegisterView()
}