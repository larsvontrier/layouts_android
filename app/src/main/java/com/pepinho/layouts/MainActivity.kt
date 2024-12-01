package com.pepinho.layouts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Actividad ListViewActivity:
        binding.btListView.setOnClickListener{
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        // Actividad FrameLayoutActivity
        binding.btFrameLayout.setOnClickListener{
            startActivity(Intent(this, FrameLayoutActivity::class.java))
        }

        // Actividada ConstraintsActivity:
        binding.btConstraint.setOnClickListener {
            startActivity(Intent(this, ConstraintsActivity::class.java))
        }

        // Animaciones
        binding.btAnimaciones.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }

        // RecyclerView
        binding.btRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))

        }

        //
        binding.btWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))

        }





    }
}