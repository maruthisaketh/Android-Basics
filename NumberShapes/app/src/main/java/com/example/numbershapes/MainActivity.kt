package com.example.numbershapes

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.floor
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class Number {
        var number = 1

        fun isTriangular(): Boolean {
            var x = 0
            var triangularNumber = 0
            while (triangularNumber < number) {
                triangularNumber += x
                x += 1
            }
            return triangularNumber == number
        }

        fun isSquare(): Boolean {
            val x = sqrt(number.toDouble())
            return x == floor(x)
        }
    }

    fun checkTriangularOrSquare(view: View) {
        val number = findViewById<EditText>(R.id.numberEditText).text.toString().toInt()
        val num = Number()
        num.number = number
        val isTriangular = num.isTriangular()
        val isSquare = num.isSquare()

        val message = if (isSquare and isTriangular) {
            "Number is Square and Triangular"
        } else if (isSquare) {
            "Number is Square"
        } else if (isTriangular) {
            "Number is Triangular"
        } else {
            "Number is neither Triangular not Square"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}