package com.example.provamobile.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray9E
import com.example.provamobile.presentation.theme.PrimaryColor

@Composable
fun BottomNavigationCustom() {
    BottomNavigation(
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Item(
                    text = R.string.home,
                    color = PrimaryColor,
                    drawable = R.drawable.ic_baseline_home_24
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Item(
                    text = R.string.add,
                    color = Gray9E,
                    drawable = R.drawable.ic_baseline_add_circle_24
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Item(
                    text = R.string.search,
                    color = Gray9E,
                    drawable = R.drawable.ic_baseline_search_24
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Item(
                    text = R.string.favorite,
                    color = Gray9E,
                    drawable = R.drawable.ic_baseline_favorite_24
                )
            }
        )
    }
}

@Composable
fun Item(@StringRes text: Int, color: Color, @DrawableRes drawable: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp)
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = stringResource(id = text)
        )
        Text(
            text = stringResource(id = text),
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            color = color,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationCustom2Preview() {
    BottomNavigationCustom()
}
