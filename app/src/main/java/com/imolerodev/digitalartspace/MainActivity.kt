package com.imolerodev.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imolerodev.digitalartspace.ui.theme.DigitalArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                    color = Color(0xFFFFFFFF)
                ) {
                    GalleryLayout()
                }
            }
        }
    }
}

@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageGallery(modifier.weight(1.0f))
        DetailImageGallery()
        ControlGallery()
    }
}

@Composable
fun ImageGallery(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        shadowElevation = 15.dp,
        color = Color(0xFFFFFFFF),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_gallery_01),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun DetailImageGallery(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = Color(0xFFEBEBEB),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Hackberry Emperor Butterfly",
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            )
            Row {
                Text(
                    text = "Stephen Rahn",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(2012)"
                )
            }
        }
    }
}

@Composable
fun ControlGallery(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                bottom = 16.dp,
                top = 16.dp
            ),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = { /*TODO*/ },
            modifier = modifier
                .width(150.dp),
        ) {
            Text(
                text = "Anterior"
            )
        }
        Button(onClick = { /*TODO*/ },
            modifier = modifier
                .width(150.dp),
        ) {
            Text(
                text = "Siguiente"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GalleryLayoutPreview() {
    DigitalArtSpaceTheme {
        GalleryLayout()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DigitalArtSpaceTheme {
//        Greeting("Android")
//    }
//}