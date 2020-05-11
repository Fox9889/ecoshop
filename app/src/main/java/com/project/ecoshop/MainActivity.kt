package com.project.ecoshop

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setUpUi()
    }

    private fun setUpUi() {
        changeActivity()
    }

    private fun changeActivity() {
        Thread(Runnable {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(this@MainActivity, Register::class.java))
                finish()
            }
        }).start()
    }

    override fun onBackPressed() {}

}