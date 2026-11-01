package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task3Text(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Task3Text(
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = stringResource(R.string.task3),
        modifier = modifier,
        style = style,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Preview(
    name = "1",
    showBackground = true,
)
@Composable
fun Task3TextPreview1() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task3Text(
                modifier = Modifier.padding(innerPadding),
                style = TextStyle(
                    color = Color.Green,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview(
    name = "2",
    showBackground = true
)
@Composable
fun Task3TextPreview2() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task3Text(
                modifier = Modifier.padding(innerPadding),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(
    name = "3",
    showBackground = true,
)
@Composable
fun Task3TextPreview3() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task3Text(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Color.Green),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline,
                    textIndent = TextIndent(firstLine = 48.sp)
                )
            )
        }
    }
}