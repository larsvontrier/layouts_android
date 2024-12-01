package com.pepinho.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityConstraintsBinding

class ConstraintsActivity : AppCompatActivity() {

    lateinit var binding: ActivityConstraintsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityConstraintsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.ivCara.setOnClickListener {
            startActivity(Intent(this, IntentConstraintsActivity::class.java).apply {
                putExtra("usuario", "Pepe Calo")
            })
        }

    }
}