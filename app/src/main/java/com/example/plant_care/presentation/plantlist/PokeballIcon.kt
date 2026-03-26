package com.example.plant_care.presentation.plantlist

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PokeballIcon(size: Dp = 36.dp, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.then(
        Modifier.let { androidx.compose.ui.Modifier.size(size) }
    )) {
        val r = this.size.minDimension / 2f
        val cx = this.size.width / 2f
        val cy = this.size.height / 2f

        // Mitad superior roja
        drawArc(
            color = Color(0xFFE53935),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true
        )

        // Mitad inferior blanca
        drawArc(
            color = Color(0xFFF5F5F5),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true
        )

        // Línea del medio
        drawLine(
            color = Color(0xFF212121),
            start = androidx.compose.ui.geometry.Offset(0f, cy),
            end = androidx.compose.ui.geometry.Offset(this.size.width, cy),
            strokeWidth = 3f
        )

        // Círculo exterior
        drawCircle(
            color = Color(0xFF212121),
            radius = r,
            style = Stroke(width = 3f)
        )

        // Círculo central blanco
        drawCircle(
            color = Color.White,
            radius = r * 0.22f
        )

        // Círculo central borde
        drawCircle(
            color = Color(0xFF212121),
            radius = r * 0.22f,
            style = Stroke(width = 3f)
        )
    }
}

