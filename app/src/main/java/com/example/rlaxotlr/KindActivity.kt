package com.example.rlaxotlr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.rlaxotlr.sampledata.Custom

class KindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kind)


        val btn: ImageView = findViewById(R.id.imageView15)
        btn.setOnClickListener {
            val nextintent = Intent(this, ChestexerciseActivity::class.java)
            startActivity(nextintent)
//            setResult(99, nextintent)
//
//            finish()


        }





    }
}