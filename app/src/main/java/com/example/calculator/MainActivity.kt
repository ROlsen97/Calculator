package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.CalcFuncs,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.SpinnerOp.adapter = adapter
        }

        /*binding.ButtonCalc.setOnClickListener {
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
        }*/
        binding.ButtonCalc.setOnClickListener {
            val oneNumber = binding.TextFirstNumber.text.toString()
            val twoNumber = binding.TextSecNumber.text.toString()
            when(binding.SpinnerOp.selectedItem.toString()){
                "+" -> binding.ViewShowResult.text = (oneNumber.toDouble() + twoNumber.toDouble()).toString()
                "-" -> binding.ViewShowResult.text = (oneNumber.toDouble() - twoNumber.toDouble()).toString()
                "*" -> binding.ViewShowResult.text = (oneNumber.toDouble() * twoNumber.toDouble()).toString()
                "/" -> binding.ViewShowResult.text = (oneNumber.toDouble() / twoNumber.toDouble()).toString()
            }
        }
    }
}