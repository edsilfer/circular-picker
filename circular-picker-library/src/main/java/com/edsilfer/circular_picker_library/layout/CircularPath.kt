package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.CircularPickerConfig

// TODO: create interface with draw method and receive it on the configuration
class CircularPath constructor(private val config: CircularPickerConfig){

    private val circumferencePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.backgroundColor)
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = config.backgroundStrokeWidth
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.backgroundTextColor)
        style = Paint.Style.FILL
        strokeCap = Paint.Cap.ROUND
        textSize = config.backgroundFontSize
    }

    fun draw(canvas: Canvas, center: Point) {
        canvas.drawCircle(center.x, center.y, config.backgroundRadius, circumferencePaint)
        drawLabel(canvas, center)
    }

    private fun drawLabel(canvas: Canvas, center: Point) {
        val message = "Hello World"
        val width = textPaint.measureText(message).toInt()
        canvas.drawText(
            message,
            center.x - width / 2,
            center.y + config.backgroundFontSize / 3,
            textPaint
        )
    }
}