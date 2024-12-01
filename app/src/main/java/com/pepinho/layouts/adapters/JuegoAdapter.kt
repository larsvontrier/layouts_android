package com.pepinho.layouts.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import com.pepinho.layouts.databinding.ListItemBinding
import com.pepinho.layouts.model.Juego

class JuegoAdapter(contexto: Context, idLayout: Int, listaJuegos: MutableList<Juego>) :
    ArrayAdapter<Juego>(contexto, idLayout, listaJuegos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding
        var vistaItem: View
        if (convertView == null) {
            // Modo tradicional:
            // vistaItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            // Modo biding:
            binding = ListItemBinding.inflate(LayoutInflater.from(context))
            vistaItem = binding.root
            // Tag es un cajón que tienen las vistas para guardar objetos asociados sin tener que
            // crear una subclase...
            vistaItem.tag = binding // Lo uso para guardar el binding en la vista (un cajón para guardar la referencia.
        } else {
            binding = convertView.tag as ListItemBinding // Recuperro el binding
            vistaItem = convertView
        }
        val juego = getItem(position)

        binding.tvJuego.text = juego?.nombre
        binding.ivJuego.load(juego?.url)

        return vistaItem
    }
}