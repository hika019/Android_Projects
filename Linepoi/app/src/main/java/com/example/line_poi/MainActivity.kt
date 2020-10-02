package com.example.line_poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.hoge.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hoge)

        //var holder = placeholder.content

        val id_A = imageA.id
        imageA.setOnClickListener(placeholder.setContentId(id_A.toInt()))


    }
}