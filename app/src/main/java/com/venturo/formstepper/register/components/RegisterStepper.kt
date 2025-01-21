package com.venturo.formstepper.register.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun RegisterStepper(
    modifier: Modifier = Modifier,
    step: Int = 1,
    stepCount: Int = 3,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        for (i in 1..stepCount) {
            Circle(
                modifier = Modifier
                    .size(24.dp)
                    .zIndex(2f),
                color = if (i <= step) Color.Blue else Color.LightGray
            )
            if (i < stepCount) {
                Line(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .zIndex(1f),
                    color = if (i < step) Color.Blue else Color.LightGray
                )
            }
        }
    }
}

@Composable
fun Line(
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
) {
    Box(
        modifier = modifier
            .height(4.dp)
            .background(color = color)
            .zIndex(1f)
    )
}

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
    size: Dp = 16.dp,
) {
    Canvas(modifier = modifier.size(size)) {
        drawCircle(
            color = color,
            radius = size.toPx(),
        )
    }
}