package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {
            val hoge = high.text.toString().toDouble() /100.0
            val fuga = weight.text.toString().toDouble()

            val bmi = fuga / (hoge* hoge)
            val ave_weight  = hoge*hoge*22.0
            val bmi_level = if (bmi <18.5) "低い"
                             else if (bmi <25) "普通"
                             else if (bmi<30) "肥満Ⅰ"
                             else if (bmi<35) "肥満Ⅱ"
                             else if (bmi<40) "肥満Ⅲ"
                             else "肥満Ⅳ"
            View_bmi.text = String.format("%.2f", bmi)
            View_ave_wight.text = String.format("%.2f", ave_weight) +"kg"
            View_bmi_str.text = bmi_level.toString()

        }
    }
}