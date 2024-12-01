package com.pepinho.layouts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityListviewBinding
import com.pepinho.layouts.model.Juego
import com.pepinho.layouts.adapters.JuegoAdapter

class ListViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListviewBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var juegos = mutableListOf<Juego>()

        val listaJuegos = resources.getStringArray(R.array.listaJuegos)

        listaJuegos.forEach { item ->
            val (nombre, descripcion) = item.split("|")
            juegos.add(Juego(nombre, descripcion))
        }
        val adapter = JuegoAdapter(this, R.layout.list_item, juegos)

        binding.lvJuegos.adapter  = adapter
//        val listView: ListView = findViewById(R.id.lvJuegos)
//        listView.adapter = adapter
    }
}



