package com.example.kotlinmessenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        register_button_register.setOnClickListener {
            val email = email_edittext_register.text.toString()
            val password = password_edittext_registaer.text.toString()

            Log.d("MainActivity", "Email is: "+ email)
            Log.d("MainActivity", "Password is: $password")



        }

        alredy_have_account_textvirew.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")


            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}