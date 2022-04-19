package com.example.provamobile.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.provamobile.R
import com.example.provamobile.presentation.theme.Gray55
import com.example.provamobile.presentation.theme.Gray75
import com.example.provamobile.presentation.theme.ProvaMobileTheme

class BookActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvaMobileTheme {
                val gradientColor = listOf(Color.Black, Color.Transparent)
                Scaffold(bottomBar = { BottomNavigationCustom() }) {
                    Column(
                        Modifier.verticalScroll(rememberScrollState())
                    ) {
                        Box(Modifier.fillMaxSize()) {
                            AsyncImage(
                                model = "https://sscdn.co/gcs/studiosol/2022/mobile/avatar.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(519.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp)
                                    .background(
                                        brush = Brush.verticalGradient(gradientColor),
                                        alpha = 0.7f
                                    )
                            )
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }
                            }
                            Box(modifier = Modifier.padding(top = 260.dp)) {
                                Card(shape = RoundedCornerShape(topStart = 32.dp)) {
                                    Column(modifier = Modifier.padding(top = 32.dp, start = 20.dp, end = 20.dp)) {
                                        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                            Text(
                                                text = "O duque e eu (Os Bridgertons Livro 1)",
                                                color = Gray55,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 20.sp,
                                                modifier = Modifier.weight(1f)
                                            )
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                                                contentDescription = null
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Julia Quinn",
                                            color = Gray75,
                                            fontSize = 14.sp
                                        )

                                        Spacer(modifier = Modifier.height(20.dp))

                                        Text(
                                            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam urna enim, ultrices vel nisi non, cursus euismod magna. Maecenas blandit lobortis iaculis. Praesent efficitur, urna non fermentum consectetur, justo est interdum dui, sodales aliquam urna quam at mi. Aliquam faucibus ex magna, vitae gravida nisl laoreet in. Etiam laoreet semper sollicitudin. Morbi eu molestie sapien. Duis lobortis ligula at varius malesuada. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc in volutpat diam, eget ultrices dolor. Suspendisse neque magna, congue id finibus et, interdum ac felis. In tempor ex eget purus facilisis consequat. Cras quis dui eu enim porttitor facilisis.\n" +
                                                "\n" +
                                                "Quisque at est interdum, luctus augue quis, vehicula ligula. Ut mauris tortor, dictum at bibendum in, luctus ut odio. Curabitur semper imperdiet vestibulum. Ut rutrum in dui eget accumsan. Ut laoreet ultricies dignissim. Morbi accumsan tristique malesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc volutpat viverra purus quis pharetra. Nullam quis mattis nibh. Nunc eget diam ac velit mattis tempor non maximus elit. Sed porttitor feugiat porta. Maecenas sagittis quam vitae felis tristique, eu molestie libero feugiat. Donec et rhoncus velit.\n" +
                                                "\n" +
                                                "In non fermentum enim. Donec a consequat eros, eu dignissim felis. Donec non blandit arcu. Nunc fermentum ligula ut felis pulvinar suscipit. Aliquam ut tempus leo. Donec quam metus, interdum in odio quis, varius tincidunt erat. Maecenas sit amet erat vitae turpis commodo finibus. Nulla tincidunt neque sed neque dapibus commodo. Proin id tortor vel nibh ullamcorper ultrices quis quis tellus. Phasellus commodo fringilla libero, scelerisque rutrum est hendrerit at. Curabitur gravida porttitor eros id finibus. Etiam in auctor arcu, et ullamcorper sapien. Etiam eu risus eget magna maximus maximus eget id urna.\n" +
                                                "\n" +
                                                "Nam non nisi non nunc tincidunt dictum et et felis. Cras a laoreet nulla. Sed non vestibulum lacus, a porttitor est. Vestibulum consequat ipsum ut nunc elementum, non euismod dolor vulputate. Phasellus fringilla, sem mollis tincidunt finibus, nunc dui semper velit, vel placerat odio arcu in mi. Donec a finibus libero. Donec quis congue erat, id porttitor tortor. Proin urna sem, lacinia nec hendrerit eu, iaculis a elit. Donec nec varius purus. Praesent blandit sapien ac gravida dapibus. Sed quis tristique tellus. Aenean quis nibh vel lectus pretium aliquam. Cras finibus purus vitae nibh finibus commodo. Sed a odio nec tortor pretium gravida fermentum eu tortor. Nulla faucibus eu tellus non maximus.\n" +
                                                "\n" +
                                                "Maecenas rutrum ullamcorper purus molestie dapibus. Donec ut consectetur purus, a rhoncus mi. Phasellus egestas ultricies enim, in gravida est dictum a. Praesent vitae lectus sit amet magna porta lacinia. Nullam et ex quam. Mauris eget lorem commodo, gravida leo nec, volutpat nisi. Aliquam eu ornare est. Ut vulputate justo in aliquam molestie. Integer imperdiet vel mauris sed vestibulum. Maecenas nec mattis nulla. Ut at massa massa. Sed tellus massa, faucibus eget fringilla a, maximus sit amet nulla.",
                                            color = Gray55,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
