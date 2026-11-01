package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task6Stretched(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Task6Original(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Оранжевый круг",
        )
    }
}

@Composable
fun Task6Stretched(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Фиолетовый овал",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task6OriginalPreview() {
    Module2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Task6Original(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task6StretchedPreview() {
    Module2Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Task6Stretched(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}