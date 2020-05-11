package com.project.ecoshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.citypanda.panchat.data.Counter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.editText7
import org.jetbrains.anko.toast

class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        button11.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }


        val backtext = findViewById <View>(R.id.backtext)
        backtext.setOnClickListener {
            onBackPressed()
            Toast.makeText(this@Register, "Back", Toast.LENGTH_SHORT).show()
        }

        button6.setOnClickListener {
            val email: String = editText666.text.toString()
            val password: String = editText7.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                toast("Please fill all required fields!")
            }

            if (password.length < 6) {
                toast("Passworrd must be at least 6 characters")
            }

            startRegister(email, password)
        }

    }
    private  fun startRegister (email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if (!it.isSuccessful)return@addOnCompleteListener
                Counter.b("User create Sussfully ${it.result?.user?.uid}")
            }
            .addOnFailureListener{
                Counter.b("Fail to create user : ${it.message}")
            }

    }
    private fun requestPermit(){

    }
}
