package com.edsilfer.circular_picker_library.model

// TODO: break in multiple objects
data class CircularPickerConfig (
    val backgroundRadius: Float = 250f,
    val backgroundColor: String = "#F0F0F0",
    val backgroundStrokeWidth: Float = 75f,
    val backgroundTextColor: String = "#0A0A0A",
    val backgroundFontSize: Float = 48f,
    val selectorRadius: Float = 80f,
    val selectorColor: String = "#97A2FF",
    val selectorTextColor: String = "#FFFFFF",
    val selectorFontSize: Float = 32f,
    val listener: OnPickerChangeListener? = null,
    val range: IntRange = 1..10,
    val step: Int = 1
)
