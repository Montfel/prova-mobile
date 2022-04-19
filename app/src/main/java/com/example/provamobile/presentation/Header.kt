package com.example.provamobile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.PrimaryColor
import kotlinx.coroutines.Job

@Composable
fun Header() {
    Card(shape = RoundedCornerShape(bottomEnd = 32.dp)) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Gray55)) {
                            append("SS")
                        }
                        withStyle(SpanStyle(color = PrimaryColor)) {
                            append("BOOK")
                        }
                    },
                    fontSize = 33.sp,
                    fontFamily = FontFamily(Font(R.font.bebas_neue))
                )

                AsyncImage(
                    model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 20.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = stringResource(id = R.string.my_books),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Gray55,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                            .background(PrimaryColor)
                            .height(4.dp)
                            .width(94.dp)
                            .align(Alignment.BottomCenter)
                    )
                }
                Text(
                    text = stringResource(id = R.string.borrowed),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Gray55
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HeaderPreview() {
//    Header()
//}
