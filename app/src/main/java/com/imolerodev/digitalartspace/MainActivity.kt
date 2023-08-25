package com.imolerodev.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    var position by remember {
        mutableStateOf(0)
    }
    val limit = 6

    val details = when(position) {
        0 -> stringResource(id = R.string.image_01).split("|")
        1 -> stringResource(id = R.string.image_02).split("|")
        2 -> stringResource(id = R.string.image_03).split("|")
        3 -> stringResource(id = R.string.image_04).split("|")
        4 -> stringResource(id = R.string.image_05).split("|")
        5 -> stringResource(id = R.string.image_06).split("|")
        else -> stringResource(id = R.string.image_01).split("|")
    }

    val image = when(position) {
        0 -> R.drawable.image_gallery_01
        1 -> R.drawable.image_gallery_02
        2 -> R.drawable.image_gallery_03
        3 -> R.drawable.image_gallery_04
        4 -> R.drawable.image_gallery_05
        5 -> R.drawable.image_gallery_06
        else -> R.drawable.image_gallery_01
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageGallery(image = image, modifier.weight(1.0f))
        DetailImageGallery(
            title = details[0],
            author = details[1],
            year = details[2])
        ControlGallery(
            {
                position = if (position < 1) limit - 1 else position - 1
            },
            {
                position = if (position == limit - 1) 0 else position + 1
            })
    }
}

@Composable
fun ImageGallery(image: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        shadowElevation = 15.dp,
        color = Color(0xFFFFFFFF),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun DetailImageGallery(title: String, author: String, year: String, modifier: Modifier = Modifier) {
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
                text = title,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            )
            Row {
                Text(
                    text = author,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = year
                )
            }
        }
    }
}

@Composable
fun ControlGallery(anterior: () -> Unit, siguiente: () -> Unit, modifier: Modifier = Modifier) {
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
        Button(onClick = anterior,
            modifier = modifier
                .width(150.dp),
        ) {
            Text(
                text = "Anterior"
            )
        }
        Button(onClick = siguiente,
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
