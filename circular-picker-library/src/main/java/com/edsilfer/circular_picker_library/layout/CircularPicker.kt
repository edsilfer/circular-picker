package com.edsilfer.circular_picker_library.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.edsilfer.circular_picker_library.geometry.Circumference
import com.edsilfer.circular_picker_library.geometry.Line
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.CircularPickerConfig

class CircularPicker @JvmOverloads constructor(
    context: Context? = null,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    private val config: CircularPickerConfig = CircularPickerConfig()
) : View(context) {

    private lateinit var center: Point
    private lateinit var selectorPosition: Point
    private lateinit var circumference: Circumference

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return
        val label = "(${selectorPosition.x.toInt()}, ${selectorPosition.y.toInt()})"
        config.indicator.draw(canvas, center, config.radius, label)
        config.selector.draw(canvas, selectorPosition, label)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = Point(w / 2f, h / 2f)
        circumference = Circumference.from(center, config.radius)
        selectorPosition = Point(center.x, center.y - config.radius)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                updateSelectorPosition(event)
                invalidate()
            }
        }
        return true
    }

    private fun updateSelectorPosition(event: MotionEvent) {
        val finger = Point(event.x, event.y)
        selectorPosition = circumference
            .intersection(Line.from(center, finger))
            .map { Pair(Line.computeDistance(it, finger), it) }
            .minBy { it.first }?.second!!
    }
}