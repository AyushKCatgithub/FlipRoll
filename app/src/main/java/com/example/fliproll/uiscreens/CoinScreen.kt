package com.example.fliproll.uiscreens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fliproll.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.animation.core.Animatable

@Composable
fun CoinScreen(
    modifier: Modifier = Modifier
) {
    var coinState by remember { mutableIntStateOf(1) }
    val imageResource = if (coinState == 1) R.drawable.coinhead else R.drawable.cointail
    val description = if (coinState == 1) "Coin Head" else "Coin Tail"
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = modifier.clip(CircleShape).size(200.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = description,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .rotate(rotation.value)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                rotation.animateTo(
                    targetValue = rotation.value + 1800f,
                    animationSpec = tween(durationMillis = 700, easing = LinearEasing)
                )
                coinState = (1..2).random()
                rotation.snapTo(rotation.value % 360f)
            }
        }) {
            Text(text = stringResource(R.string.toss), fontSize = 22.sp)
        }
    }
}

