package com.example.citizennow.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.citizennow.databinding.ActivitySpalashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding:ActivitySpalashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySpalashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
             binding.animationView.playAnimation()
            val intent = Intent(this, MainActivity::class.java)
             binding.animationView.pauseAnimation()
            startActivity(intent)
            finish()
        }, 3400)
    }
}