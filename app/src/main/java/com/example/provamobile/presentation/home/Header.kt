package com.example.provamobile.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.PrimaryColor

@Composable
fun Header(picture: String?) {
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
                    model = picture ?: "",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            }
            TabRow(
                selectedTabIndex = 0,
                backgroundColor = Color.White,
                contentColor = PrimaryColor,
                modifier = Modifier
                    .height(48.dp)
                    .width(250.dp)
                    .padding(start = 20.dp)
            ) {
                Tab(selected = true, onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(id = R.string.my_books),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Gray55,
                    )
                }
                Tab(selected = false, onClick = { /*TODO*/ }) {
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
}

//@Preview(showBackground = true)
//@Composable
//fun HeaderPreview() {
//    Header()
//}
