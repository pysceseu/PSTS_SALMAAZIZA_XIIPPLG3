package com.salma.psts_salmaaziza_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val pindah= Intent(this, RecyclerViewActivityy::class.java)
            startActivity(pindah)
            finish()
        }, 2000)
    }
}