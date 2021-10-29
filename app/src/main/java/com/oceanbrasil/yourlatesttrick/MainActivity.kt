package com.oceanbrasil.yourlatesttrick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                HelloWorld(texto = "Olá, planeta!")
                Login()
                HelloWorld(texto = "oies, terrinha!!!")
            }
            GlobalScope.launch {
                val noticias = pegarNoticias().await()
                var listaDeNoticias = listOf(noticias.toString())
            }
        }
    }
}

suspend fun pegarNoticias() = GlobalScope.async {
    // pre-processamento de algo
    // fazer a task demorada
    delay(2000)
    // atualizacoes
    // Retrofit ..
    // pos-processamento
}

@Composable
fun HelloWorld(texto: String) {
    Row() {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagem android",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(
                    1.5.dp,
                    MaterialTheme.colors.secondaryVariant,
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.padding(all = 8.dp
            )
        ) {
            Text(text = texto,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h4
            )
            Text(text = stringResource(R.string.app_name),
                color = MaterialTheme.colors.secondary)

        }
    }
}

@Preview
@Composable
fun PreviewHelloWorld() {
    HelloWorld(texto = "oies, terrinha!")
}

data class Pessoa(
    val username: String,
    val senha: String
)
@Composable
fun Login() {
    Column() {
        val state = Pessoa("user", "123")
        Row() {
            Text("User:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(state.username)
        }
        Row() {
            Text(text = "Password:")
            Spacer(modifier = Modifier.width(4.dp))
            Text(state.senha)
        }
        TextButton( onClick = {

        }) {

        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    Login()
}
