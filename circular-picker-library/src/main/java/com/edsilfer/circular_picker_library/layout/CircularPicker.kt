package com.edsilfer.circular_picker_library.layout

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.edsilfer.circular_picker_library.geometry.Circumference
import com.edsilfer.circular_picker_library.geometry.Line
import com.edsilfer.circular_picker_library.geometry.Point
import com.edsilfer.circular_picker_library.model.CircularPickerConfig

class CircularPicker @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    private val config: CircularPickerConfig
) : View(context) {

    private val circularPath: CircularPath = CircularPath(config)

    private lateinit var center: Point
    private lateinit var selector: Selector
    private lateinit var circumference: Circumference

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) {
            return
        }
        circularPath.draw(canvas, center)
        selector.draw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        center = Point(w / 2f, h / 2f)
        circumference = Circumference.from(center, config.backgroundRadius)
        selector = Selector(Point(center.x, center.y - config.backgroundRadius), config)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                val finger = Point(event.x, event.y)
                /*
                TODO: properly implement the step. Suggestion:
                1) Pre-compute the points where the selector can be drawn;
                 */
                val delta: Float = Line.computeDistance(finger, selector.position)
                val divisions = (config.range.last - config.range.first) / config.step
                if (divisions > 0 && delta < circumference.length() / divisions) {
                    return false
                }
                // TODO: check if listener is different than null and if so call it with the proper step value
                // TODO: on the changer listener create API that allows setting a new text for the selector and background label
                selector.position = circumference.intersection(Line.from(center, finger))
                    .map { Pair(Line.computeDistance(it, finger), it) }
                    .minBy { it.first }?.second!!
                Log.i("s", "entrei aqui")
                invalidate()
            }
        }
        return true
    }
}