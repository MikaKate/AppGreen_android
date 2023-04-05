package com.example.a28mar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nameProduct = findViewById<TextView>(R.id.nameProduct)
        nameProduct.text = intent.getStringExtra("name")
    }
}