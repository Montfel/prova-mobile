package com.example.provamobile.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.PrimaryColor

@Composable
fun Section(@StringRes text: Int, showAll: Boolean = true) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(id = text),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Gray55
        )
        if (showAll) {
            Text(
                text = stringResource(id = R.string.show_all),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionPreview() {
    Section(text = R.string.library)
}
