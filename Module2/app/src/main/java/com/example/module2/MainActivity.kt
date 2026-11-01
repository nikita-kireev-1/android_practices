package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.module2.ui.theme.Module2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Scaffold() { innerPadding ->
                    Screen(null, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = Devices.PHONE,
    showBackground = true,
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = Devices.TABLET,
    showBackground = true,
)
@Preview(
    name = "round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true",
    showBackground = true,
    backgroundColor = 0xFFFFFF00
)
@Composable
fun ScreenPreview(){
    Scaffold(
        containerColor = Color.Transparent
    ) { innerPadding ->
        Screen("Nikita", Modifier.padding(innerPadding))
    }
}
@Composable
fun Screen(
    name : String?,
    modifier : Modifier,
){
    Text(
        text =
            if(name == null){
                "Имя не задано"
            }else{
                "Здравствуйте $name"
            },
        modifier = modifier
    )
}