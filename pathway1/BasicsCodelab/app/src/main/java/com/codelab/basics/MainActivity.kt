package com.codelab.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(
    modifier: Modifier = Modifier
) {
    var shouldShownOnboarding by remember { mutableStateOf(true) }
    if (shouldShownOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShownOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        for (name in names) {
            val expanded = remember { mutableStateOf(false) }
            val extraPadding = if (expanded.value) 48.dp else 0.dp
            Surface(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Row(modifier = Modifier.padding(24.dp)) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = extraPadding)
                    ) {
                        Text(text = "Hello")
                        Text(text = "${name}!")
                    }
                    Button(
                        onClick = { expanded.value = !expanded.value }
                    ) {
                        Text(if (expanded.value) "Show less" else "Show more")
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the basic Codelab!!")
        Button(
            modifier = Modifier.padding(24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}

@Preview(showBackground = true)
@Composable
private fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}
