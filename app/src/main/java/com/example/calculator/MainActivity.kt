package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import android.widget.EditText
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        val num1 = editTextNumber1.text.toString().toDouble()
        val num2 = editTextNumber2.text.toString().toDouble()
        var result = 0.0

        when (view.id) {
            R.id.buttonAdd -> result = num1 + num2
            R.id.buttonSubtract -> result = num1 - num2
            R.id.buttonMultiply -> result = num1 * num2
            R.id.buttonDivide -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    textViewResult.text = "Error: Cannot divide by zero!"
                    return
                }
            }
        }

        textViewResult.text = "Result: $result"
    }
}
