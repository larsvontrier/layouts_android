package com.pepinho.layouts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btSumar.setOnClickListener {
            binding.ivFoto.apply {
                visibility = View.VISIBLE
                animate().alpha(0.0f).scaleX(0.2f).scaleY(0.2f).setDuration(2000).start()
            }
        }

        binding.btRestar.setOnClickListener {
            binding.ivFoto.apply {
                visibility = View.VISIBLE
                animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(1000).start()
            }
        }

        binding.ivFoto.setOnClickListener {
            startActivity(Intent(this, ConstraintsActivity::class.java).apply {
                putExtra("usuario", "Pepe")
            })
        }



    }
}