package com.sadeeq.encoders.retrofitinjetpackcompose.components

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.sadeeq.encoders.retrofitinjetpackcompose.R
import com.sadeeq.encoders.retrofitinjetpackcompose.viewmodel.MyViewModel


@Composable
fun LoginButton(
    viewModel: MyViewModel,
    username: String,
    password: String,
    onClick: (String, String) -> Unit
) {
    val context = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.purple_200)
        ), onClick = {
            if (username.isEmpty()) {
                Toast.makeText(context, "Username: is Empty", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(
                    context, "Username: $username\nPassword: $password", Toast.LENGTH_SHORT
                ).show()
                viewModel.login(username,password)
            }
        },

        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp)
            .border(1.dp, MaterialTheme.colorScheme.primaryContainer, CircleShape)
    ) {


        Text(
            "Login", style = MaterialTheme.typography.titleSmall.copy(color = Color.Blue)
        )
    }

}
