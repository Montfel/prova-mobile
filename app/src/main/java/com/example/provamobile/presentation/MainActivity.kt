package com.example.provamobile.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.provamobile.apolloClient
import com.example.provamobile.presentation.theme.GrayF2
import com.example.provamobile.presentation.theme.ProvaMobileTheme
import com.example.rocketreserver.UserPictureQuery

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val response = lifecycleScope.launchWhenResumed {
            apolloClient.query(UserPictureQuery()).execute().data
        }
        setContent {
            ProvaMobileTheme {
                Scaffold(
                    bottomBar = { BottomNavigationCustom() },
                    backgroundColor = GrayF2,
                ) { paddingValue ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(paddingValue)
                    ) {
                        Header()
                        FavoriteBooks()
                        CardBottom()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvaMobileTheme {
    }
}
