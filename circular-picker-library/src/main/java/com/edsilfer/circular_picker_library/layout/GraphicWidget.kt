package com.edsilfer.circular_picker_library.layout

import android.graphics.Canvas

/**
 * Sets the contract for drawing the element of the {@link CircularPicker} widget
 */
interface GraphicWidget<T> {

    fun draw(canvas: Canvas)

}