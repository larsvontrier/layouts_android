package com.pepinho.layouts.model

class Juego (val nombre: String, val url: String) {
    override fun toString(): String {
        return "'$nombre' ('$url')"
    }
}
