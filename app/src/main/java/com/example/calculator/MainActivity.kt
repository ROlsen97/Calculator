package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.ButtonPlus.setOnClickListener {
            val inputfield = binding.TextFirstNumber
            val numberToCalculate = inputfield.text.toString().trim()
            if (numberToCalculate.isEmpty()) {
                inputfield.error = "intet tal"
                return@setOnClickListener
            }
            val inputfield2 = binding.TextSecNumber
            val secnumberToCalc = inputfield2.text.toString().trim()
            if (secnumberToCalc.isEmpty()) {
                inputfield2.error = "intet tal"
                return@setOnClickListener
            }
            var result = (numberToCalculate.toDouble() + secnumberToCalc.toDouble()).toString()
            binding.ViewShowResult.text = "Result : $result"
        }
    }
}