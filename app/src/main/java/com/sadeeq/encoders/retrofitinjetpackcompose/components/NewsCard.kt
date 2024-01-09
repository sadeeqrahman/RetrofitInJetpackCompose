package com.sadeeq.encoders.retrofitinjetpackcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sadeeq.encoders.retrofitinjetpackcompose.R
import com.sadeeq.encoders.retrofitinjetpackcompose.models.NewsResponse

@Composable
fun NewsCard(newsResponse: NewsResponse.Source) {
    val context = LocalContext.current

    Card(
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.white)
        ),
        border = BorderStroke(1.dp, color = Color.Blue).copy(
            1.dp, brush = Brush.horizontalGradient(
                listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow),
                tileMode = TileMode.Repeated
            )
        ),
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth()
            .clickable {

            }) {

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = newsResponse.country!!,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = newsResponse.name!!,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = newsResponse.description!!,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
        }
    }
}
