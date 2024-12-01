package com.pepinho.layouts

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pepinho.layouts.databinding.ActivityMainBinding
import com.pepinho.layouts.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Habilitamos Javascript
        val wvPagina = binding.wvPagina
        wvPagina.settings.javaScriptEnabled = true
        wvPagina.settings.domStorageEnabled = true // Habilitar almacenamiento DOM
        wvPagina.settings.useWideViewPort = true // Habilitar vista amplia
        wvPagina.settings.loadWithOverviewMode = true // Ajustar el contenido al tamaño de la pantalla
        // Para qua aparezca embebido en la actividad y personalizo el cliente
        wvPagina.webViewClient =  object : WebViewClient() {

            // ctrl+o para sobrescribir los métodos que desees

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                // No puede conectarser a la página
                Toast.makeText(baseContext, "Ha sucedido un error", Toast.LENGTH_SHORT).show()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // Iniciada la carga de la página
                Toast.makeText(baseContext, "Cargando página", Toast.LENGTH_SHORT).show()

            }

            override fun onPageFinished(view: WebView, url: String) {
                // Termina la carga de la página
                Toast.makeText(baseContext, "Carga completada", Toast.LENGTH_SHORT).show()
            }
        }
        try {
            wvPagina.loadUrl("pepinho.com") // Ojo, es síncrona!
        } catch (e: Exception){
            Log.d("Error: ", "{${e.message}")
        }
    }


}
