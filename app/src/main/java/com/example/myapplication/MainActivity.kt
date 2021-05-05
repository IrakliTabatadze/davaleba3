package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand = 0.0
    private var operation = ""
    private var wertili = true


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is Button) {
            val number = clickedView.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0")
                result = ""
            resultTextView.text = result + number
        }


    }
    fun operationClick(clickedView: View){

        if(clickedView is Button){
            wertili = true
            var resultText = resultTextView.text.toString()
            if (resultText.isEmpty())
                return
            operand = resultText.toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = ""


        }
    }
    fun equalsClick(clickedView: View) {
        wertili = true
        val resultText = resultTextView.text.toString()
        if (resultText.isEmpty())
            return
        val secondOperand = resultText.toDouble()
        var shedegi = 0.0
        if(operation == "+"){
            shedegi = (operand.toDouble() + secondOperand).toString().toDoubleOrNull()!!
            if(shedegi == null){
                resultTextView.text = (operand + secondOperand).toString().toInt().toString()

            }else {
                resultTextView.text = shedegi.toString().toDouble().toString()
            }



        }else if (operation =="-"){
            shedegi = (operand.toDouble() -  secondOperand).toString().toDoubleOrNull()!!
            if(shedegi == null){
                resultTextView.text = (operand.toDouble() - secondOperand).toString()

            }else {
                resultTextView.text = shedegi.toString().toDouble().toString()
            }

        }else if (operation == "*"){
            shedegi = (operand.toDouble() * secondOperand).toString().toDoubleOrNull()!!
            if(shedegi == null){
                resultTextView.text = (operand.toDouble() * secondOperand).toString().toInt().toString()

            } else {
                resultTextView.text = shedegi.toString().toDouble().toString()
            }

        }else if (operation == "/"){
            shedegi = (operand.toDouble() / secondOperand).toString().toDoubleOrNull()!!
            if(shedegi == null){
                resultTextView.text = (operand.toDouble() / secondOperand).toString().toInt().toString()

            } else {
                resultTextView.text = shedegi.toString().toDouble().toString()
            }

        }


    }
    fun clearClick(clickedView: View) {
        resultTextView.text = ""
        wertili = true

    }
    fun dotClick(clickedView: View) {
        var checkDouble = resultTextView.text.toString().toDoubleOrNull()
        if(checkDouble != null){
            wertili = true


        }

        if (wertili == true){
            resultTextView.text = resultTextView.text.toString() + "."
            wertili = false

        }

    }
    fun delClick(clickedView: View) {
        val text = resultTextView.text.toString()
        if(text.isNotEmpty()){



            resultTextView.text = text.dropLast(1)
        }else{
            resultTextView.text = ""
        }


    }

}
