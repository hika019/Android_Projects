package com.example.dentaku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.test.*




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        var str = ""
        var str2 = ""
        var ans = 0.0
        var point_flag = 0
        var calc_flag = 0
        var start_flag = 0

        clear.setOnClickListener {
            str = ""
            ans = 0.0
            point_flag = 0
            textView.text = str
        }

        button0.setOnClickListener {
            str += "0"
            textView.text = str
        }

        button1.setOnClickListener {
            str += "1"
            textView.text = str
        }
        button2.setOnClickListener {
            str += "2"
            textView.text = str
        }
        button3.setOnClickListener {
            str += "3"
            textView.text = str
        }
        button4.setOnClickListener {
            str += "4"
            textView.text = str
        }
        button5.setOnClickListener {
            str += "5"
            textView.text = str
        }

        button6.setOnClickListener {
            str += "6"
            textView.text = str
        }
        button7.setOnClickListener {
            str += "7"
            textView.text = str
        }
        button8.setOnClickListener {
            str += "8"
            textView.text = str
        }
        button9.setOnClickListener {
            str += "9"
            textView.text = str
        }
        point.setOnClickListener {
            if(point_flag == 0){
                str += "."
                textView.text = str
                point_flag = 1
            }
        }

        textView2.text = ans.toString()

        add.setOnClickListener {

            if(calc_flag == 0 ) ans += str.toDouble()
            if(calc_flag == 1 ) ans -= str.toDouble()
            if(calc_flag == 2 ) ans = ans * str.toDouble()
            if(calc_flag == 3 ) ans = ans / str.toDouble()
            str=""
            textView2.text = ans.toString() + "+"
            calc_flag = 0
        }

        sub.setOnClickListener {
            if (str == "" || textView2.text == "") str = "0.0"
            if(calc_flag == 0 ) ans += str.toDouble()
            if(calc_flag == 1 ) ans -= str.toDouble()
            if(calc_flag == 2 ) ans = ans * str.toDouble()
            if(calc_flag == 3 ) ans = ans / str.toDouble()
            str=""
            textView2.text = ans.toString() + "-"
            calc_flag = 1
        }

        dot.setOnClickListener {
            if (str == "") str = "0.0"
            if(calc_flag == 0 ) ans += str.toDouble()
            if(calc_flag == 1 ) ans -= str.toDouble()
            if(calc_flag == 2 ) ans = ans * str.toDouble()
            if(calc_flag == 3 ) ans = ans / str.toDouble()
            str=""
            textView2.text = ans.toString() + "×"
            calc_flag = 2
        }

        division.setOnClickListener {
            if (str != "" || str.toDouble() != 0.0 ) {
                if (calc_flag == 0) ans += str.toDouble()
                if (calc_flag == 1) ans -= str.toDouble()
                if (calc_flag == 2) ans = ans * str.toDouble()
                if (calc_flag == 3) ans = ans / str.toDouble()
            }else textView.text = "0で割ることはできません"
            str=""
            textView2.text = ans.toString() + "×"
            calc_flag = 3
        }


        equal.setOnClickListener {
            if (str != "") {
                if (calc_flag == 0) ans += str.toDouble()
                if (calc_flag == 1) ans -= str.toDouble()
                if (calc_flag == 2) ans = ans * str.toDouble()
                if (calc_flag == 3) ans = ans / str.toDouble()
            }

            calc_flag = 0
            textView.text = ans.toString()
            textView2.text = ""

        }



    }
}