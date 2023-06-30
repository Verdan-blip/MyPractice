package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val validateButton = findViewById<Button>(R.id.button)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val resultText = findViewById<TextView>(R.id.textViewResult)

        validateButton?.setOnClickListener {
            val name = editTextName.text.toString()
            try {
                val height = editTextHeight.text.toString().toInt()
                val weight = editTextWeight.text.toString().toInt()
                val age = editTextAge.text.toString().toInt()

                if (!validateFields(name, height, weight, age)) {
                    resultText.text = getString(R.string.invalid_fields_message)
                } else {
                    val result: Float = calcCalorieAllowance(name, height, weight, age)
                    resultText.text = String.format("Ответ: $result")
                }

            } catch (ex: NumberFormatException) {
                resultText.text = getString(R.string.empty_fields_message)
            }
        }

    }

    private fun validateFields(name: String,
                               height: Int,
                               weight: Int,
                               age: Int
    ) : Boolean =
        name.length in 1..49 &&
                height > 0 && height < 250 &&
                weight > 0 && weight < 250 &&
                age > 0 && age < 150

    private fun calcCalorieAllowance(name: String,
                                     height: Int,
                                     weight: Int,
                                     age: Int
    ) : Float =
        weight * 10 + height * 6.25f + age * 5 + name.length

}