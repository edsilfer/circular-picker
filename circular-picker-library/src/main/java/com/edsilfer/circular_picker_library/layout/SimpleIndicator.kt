package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.SimpleIndicatorConfig

/**
 * A {@link CircularPathConfig} implementation that draws a  circle with the new value in the center
 */
class SimpleIndicator constructor(
    private val config: SimpleIndicatorConfig
) : Indicator {

    private val circumferencePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.color)
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = config.strokeWidth
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor(config.textColor)
        style = Paint.Style.FILL
        strokeCap = Paint.Cap.ROUND
        textSize = config.fontSize
    }


    override fun draw(canvas: Canvas, center: Point, radius: Float, label: String) {
        canvas.drawCircle(center.x, center.y, radius, circumferencePaint)
        drawLabel(canvas, center, label)
    }

    private fun drawLabel(canvas: Canvas, center: Point, label: String) {
        val width = textPaint.measureText(label).toInt()
        canvas.drawText(
            label,
            center.x - width / 2,
            center.y + config.fontSize / 3,
            textPaint
        )
    }
}