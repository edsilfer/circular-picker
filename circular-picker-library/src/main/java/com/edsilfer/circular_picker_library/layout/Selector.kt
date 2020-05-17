package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.CircularPickerConfig

// TODO: create interface so that the user can specify a customizable object
class Selector constructor(start: Point, private val config: CircularPickerConfig) {

    /*
    TODO: improve colors and create shadow for the selector
     */
    private val selectorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.selectorColor)
        style = Paint.Style.FILL
        strokeCap = Paint.Cap.ROUND
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.selectorTextColor)
        style = Paint.Style.FILL
        strokeCap = Paint.Cap.ROUND
        textSize = config.selectorFontSize
    }

    var position: Point = start

    fun draw(canvas: Canvas) {
        canvas.drawCircle(position.x, position.y, config.selectorRadius, selectorPaint)
        drawLabel(canvas)
    }

    private fun drawLabel(canvas: Canvas) {
        val message = "(${position.x.toInt()}, ${position.y.toInt()})"
        val width = textPaint.measureText(message).toInt()
        canvas.drawText(
            message,
            position.x - width / 2,
            position.y + config.selectorRadius / 3,
            textPaint
        )
    }
}