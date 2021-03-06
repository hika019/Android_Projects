package com.example.kotlinmessenger.registerlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.example.kotlinmessenger.R
import com.example.kotlinmessenger.messages.LatestMessageActivity
import com.example.kotlinmessenger.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        register_button_register.setOnClickListener {
            performRegister()
        }

        alredy_have_account_textvirew.setOnClickListener {
            Log.d("RegisterActivity", "Try to show login activity")


            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        select_photo_button_register.setOnClickListener {
            Log.d("RegisterActivity", "Try to show photo selector")
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

    }

    var selectedPhotoUri: Uri? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){
            Log.d("RegisterActivity", "Photo was selected")

            selectedPhotoUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)

            select_photo_image_view_register.setImageBitmap(bitmap)

            select_photo_button_register.alpha = 0f

//            val bitmapDrawable = BitmapDrawable(bitmap)
//            select_photo_button_register.setBackgroundDrawable(bitmapDrawable)

        }

    }


    private fun performRegister(){
        val email = email_edittext_register.text.toString()
        val password = password_edittext_registaer.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter text in email/password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("RegisterActivity", "Email is: "+ email)
        Log.d("RegisterActivity", "Password is: $password")

        if (selectedPhotoUri == null || username_edittext_register.text.toString().isEmpty()) {
            Toast.makeText(this,"Please select to Photo or enter text in username", Toast.LENGTH_SHORT).show()
            return
        }


        //create a user email and password by Firebase Authentication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)

            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener

                //else if successful
                Log.d("RegisterActivity", "Successfully created user with uid: ${it.result?.user?.uid}")

                uploadImagetoFirebaseStorage()
            }
            .addOnFailureListener {
                Log.d("RegisterActivity", "Failed to create user: ${it.message}")
                Toast.makeText(this,"Failed to create user: ${it.message}", Toast.LENGTH_LONG).show()


            }
    }

    private fun uploadImagetoFirebaseStorage() {
        if (selectedPhotoUri == null) return
        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")

        ref.putFile(selectedPhotoUri!!)
            .addOnSuccessListener {
                Log.d("RegisterActivity", "Successfully uploaded image: ${it.metadata?.path}")

                ref.downloadUrl.addOnSuccessListener {

                        Log.d("RegisterActivity", "File Location: $it")

                    saveUserToFirebaseDatabase(it.toString())
                }
            }
    }

    private fun saveUserToFirebaseDatabase(profileImageUrl: String){
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        val user = User(uid, username_edittext_register.text.toString(), profileImageUrl)

        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("RegisterActivity", "Finally we saved the user to Firebase Database")

                val intent = Intent(this, LatestMessageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
    }

}

//class User(val uid: String, val username: String, val profileImageUrl: String){
//    constructor(): this("", "", "")
//}