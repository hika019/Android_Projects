package com.example.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.sent.*
import kotlinx.android.synthetic.main.text.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sent)


        sent_button.setOnClickListener {
            val temp = chat_box.text.toString()
            textView2.text = temp.toString()
            chat_box.text.clear()
        }

    }

    fun hoge(str:String){
        setContentView(R.layout.text)
        textView.text = str
    }

}