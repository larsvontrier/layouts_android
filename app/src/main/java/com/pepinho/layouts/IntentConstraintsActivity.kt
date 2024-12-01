package com.pepinho.layouts

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityConstraintsBinding
import com.pepinho.layouts.databinding.ActivityIntentsConstraintsBinding

class IntentConstraintsActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntentsConstraintsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntentsConstraintsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usuario = intent.getStringExtra("usuario")

        binding.tvUsuario.text = usuario
    }
}