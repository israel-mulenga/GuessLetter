package com.example.guessletter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessletter.ui.theme.GuessLetterTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessLetterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GuessLetterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GuessLetterScreen(modifier: Modifier = Modifier) {
    val letters = stringArrayResource(id = R.array.liste_lettres)
    var currentLetter by remember { mutableStateOf(letters[Random.nextInt(letters.size)]) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentLetter,
                fontSize = 120.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                currentLetter = letters[Random.nextInt(letters.size)]
            },
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(text = stringResource(id = R.string.btn_devine))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuessLetterScreenPreview() {
    GuessLetterTheme {
        GuessLetterScreen()
    }
}
