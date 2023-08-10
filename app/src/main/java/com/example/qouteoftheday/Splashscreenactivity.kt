@file:Suppress("UNUSED_EXPRESSION")

package com.example.qouteoftheday

import android.content.Intent
import android.graphics.Color.alpha
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

class Splashscreenactivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreenactivity)

        splashTheScreeen()



    }

    private fun intent(splashscreenactivity: Splashscreenactivity, java: Class<MainActivity>): Intent? {
        TODO("Not yet implemented")
    }

    private fun splashTheScreeen(){
        val Iv_splash
        0f.also { Iv_splash:alpha = it }

        Iv_splash.animate().apply {
            val value
            alpha(value;0f)
            var duration = 800
        }.withEndAction {

            startActivity(intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()

        }.start()
    }
}
