package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier) {
    if (count > 0) {
        Text("You've had $count glasses.")
    }
    Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
        Text("Add one")
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreView() {
    StatefulCounter()
}
