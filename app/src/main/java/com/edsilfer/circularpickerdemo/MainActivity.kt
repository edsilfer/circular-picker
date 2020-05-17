package com.edsilfer.circularpickerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edsilfer.circular_picker_library.layout.CircularPicker
import com.edsilfer.circular_picker_library.model.CircularPickerConfig

class MainActivity : AppCompatActivity() {

    /*
    TODO: create several activities with examples of usage for this library
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val circularPicker = CircularPicker(this, config = CircularPickerConfig())
        setContentView(circularPicker)
    }
}
