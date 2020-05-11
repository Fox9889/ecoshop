package com.project.ecoshop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.citypanda.panchat.data.Counter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import java.util.regex.Pattern

class Login : AppCompatActivity() {
    private val PASSWORD_PATTERNS = Pattern.compile(
        "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                //"(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        button110.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }




        editText6.setOnTouchListener(View.OnTouchListener { _, _ ->
            textto.setTextColor(Color.parseColor("#555BF3"))
            textoor.setTextColor(Color.parseColor("#9DA6B3"))
            return@OnTouchListener false
        })

        editText7.setOnTouchListener(View.OnTouchListener { _, _ ->
            textoor.setTextColor(Color.parseColor("#555BF3"))
            textto.setTextColor(Color.parseColor("#9DA6B3"))
            return@OnTouchListener false
        })


        editText7.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                val password: String = editText7.text.toString()
                if (PASSWORD_PATTERNS.matcher(password).matches()) {
                    Load1.visibility = View.VISIBLE
                    Load1.animate().alpha(1f)
                }

                else{Load1.visibility = View.INVISIBLE
                    Load1.animate().alpha(0f)}
            }
        })

        editText6.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val email: String = editText6.text.toString()
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Load2.visibility = View.VISIBLE
                }
                else { Load2.visibility = View.INVISIBLE }
            }
        })


        val back = findViewById <View>(R.id.back)
        back.setOnClickListener {
            onBackPressed()
            Toast.makeText(this@Login, "Back", Toast.LENGTH_SHORT).show()
        }


        button5.setOnClickListener {
            val email: String = editText6.text.toString()
            val password: String = editText7.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                toast("Please fill all required fields!")
                return@setOnClickListener
            }

            if (password.length < 6) {
                toast("Password must be at least 6 characters")
                return@setOnClickListener
            }
            startLogin(email,password)
        }
    }


    private  fun startLogin (email: String, password: String) {
        Counter.b("Email $email Password $password")
    }
}
