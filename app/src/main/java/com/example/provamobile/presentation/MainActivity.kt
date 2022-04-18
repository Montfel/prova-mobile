package com.example.provamobile.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.provamobile.apolloClient
import com.example.provamobile.ui.theme.GrayF2
import com.example.provamobile.ui.theme.ProvaMobileTheme
import com.example.rocketreserver.UserPictureQuery

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val response = lifecycleScope.launchWhenResumed {
            apolloClient.query(UserPictureQuery()).execute().data
        }
        setContent {
            ProvaMobileTheme {
                Scaffold(
                    topBar = { Header(response) },
                    bottomBar = { BottomNavigationCustom() },
                    backgroundColor = GrayF2,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
                        Middle()
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
