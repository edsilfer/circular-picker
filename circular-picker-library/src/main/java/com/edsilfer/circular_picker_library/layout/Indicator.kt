package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import com.edsilfer.circular_picker_library.geometry.Point

/**
 * Sets the contract for a indicator belonging to the {@link CircularPicker} widget
 */
interface Indicator {

    /**
     * Updates the value to be displayed on the center after calling draw
     */
    fun draw(canvas: Canvas, center: Point, radius: Float, label: String)

}