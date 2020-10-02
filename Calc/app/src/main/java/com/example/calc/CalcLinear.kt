package com.example.calc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CalcLinear : AppCompatActivity(){

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.calc_linear)

        val editText1 = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val textView = findViewById<TextView>(R.id.textView)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        //Add
        button1.setOnClickListener {
            textView.text = (editText1.text.toString().toInt() + editText2.text.toString(). toInt()).toString()
        }

        //Sub
        button2.setOnClickListener {
            textView.text = (editText1.text.toString().toInt() - editText2.text.toString(). toInt()).toString()
        }
    }
}