package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.SimpleSelectorConfig

/**
 * A simple implementation that draws a knob that the user can control
 */
class SimpleSelector constructor(
    private val config: SimpleSelectorConfig
) : Selector {

    /*
    TODO: improve colors and create shadow for the selector
     */
    private val selectorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.color)
        style = Paint.Style.FILL
        strokeCap = Paint.Cap.ROUND
    }

    override fun draw(canvas: Canvas, position: Point, label: String) {
        canvas.drawCircle(position.x, position.y, config.radius, selectorPaint)
    }
}