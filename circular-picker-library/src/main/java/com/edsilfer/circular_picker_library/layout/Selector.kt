package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas
import com.edsilfer.circular_picker_library.geometry.Point

/**
 * Sets the contract for a selector belonging to the {@link CircularPicker} widget
 */
interface Selector {

    fun draw(canvas: Canvas, position: Point, label: String)

}