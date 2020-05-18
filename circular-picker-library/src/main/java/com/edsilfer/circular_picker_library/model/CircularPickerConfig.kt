package com.edsilfer.circular_picker_library.model

import com.edsilfer.circular_picker_library.layout.Indicator
import com.edsilfer.circular_picker_library.layout.Selector
import com.edsilfer.circular_picker_library.layout.SimpleIndicator
import com.edsilfer.circular_picker_library.layout.SimpleSelector

/**
 * The configuration for the {@link CircularPicker} widget
 */
data class CircularPickerConfig constructor(
    val indicator: Indicator = SimpleIndicator(SimpleIndicatorConfig()),
    val selector: Selector = SimpleSelector(SimpleSelectorConfig()),
    val radius: Float = 300f
)
