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
import androidx.compose.ui.tooling.preview.Preview
import com.example.module2.ui.theme.Module2Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task7ContactRow(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

val contacts = listOf(
    Contact(
        name = "Евгений",
        patronymic = "Андреевич",
        surname = "Лукашин",
        phone = "+7 495 495 95 95",
        address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
    ),
    Contact(
        name = "Василий",
        patronymic = "Егорович",
        surname = "Кузякин",
        phone = "---",
        address = "Ивановская область, дер. Крутово, д. 4"
    ),
    Contact(
        name = "Людмила",
        patronymic = "Прокофьевна",
        surname = "Калугина",
        phone = "+7 495 788 78 78",
        address = "Москва, Большая Никитская, д. 43, кв. 290"
    )
)

@Composable
fun ContactDetails(
    contact: Contact,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            text = "Имя: ${contact.name}",
        )
        Text(
            text = "Отчество: ${contact.patronymic}",
        )
        Text(
            text = "Фамилия: ${contact.surname}",
        )
        Text(
            text = "Мобильный телефон: ${contact.phone}",
        )
        Text(
            text = "Адрес: ${contact.address}",
        )
    }
}

@Composable
fun Task7Contact(modifier: Modifier = Modifier) {
    ContactDetails(
        contact = contacts[0],
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun Task7ContactList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        contacts.forEach { contact ->
            ContactDetails(
                contact = contact,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally
            )
        }
    }
}

@Composable
fun Task7ContactRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactDetails(
            contact = contacts[0],
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        Image(
            painter = painterResource(
                android.R.drawable.btn_star_big_on
            ),
            contentDescription = "Star",
            modifier = Modifier.size(25.dp)
        )
    }
}

@Preview(
    name = "1",
    showBackground = true,
)
@Composable
fun Task7ContactPreview() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task7Contact(Modifier.padding(innerPadding))
        }
    }
}

@Preview(
    name = "2",
    showBackground = true,
)
@Composable
fun Task7ContactListPreview() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task7ContactList(Modifier.padding(innerPadding))
        }
    }
}

@Preview(
    name = "3",
    showBackground = true,
)
@Composable
fun Task7ContactRowPreview() {
    Module2Theme {
        Scaffold() { innerPadding ->
            Task7ContactRow(Modifier.padding(innerPadding))
        }
    }
}