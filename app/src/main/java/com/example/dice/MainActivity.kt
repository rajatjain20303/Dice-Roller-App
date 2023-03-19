package com.example.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dice.ui.theme.DiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    diceWithButtonAndImage(modifier=Modifier)
                }
            }
        }
    }
}

@Composable
fun diceWithButtonAndImage(modifier:Modifier= Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
){
    Column(modifier=Modifier,
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        var result by remember { mutableStateOf( 1) }
        val imageRes=when(result){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Image(
            painter=painterResource(imageRes),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick={result=(1..6).random()}){
            Text(
               text= stringResource(R.string.RollingCommand)
            )
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceTheme {
        diceWithButtonAndImage(modifier=Modifier)
    }
}