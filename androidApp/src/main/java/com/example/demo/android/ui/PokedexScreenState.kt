package com.example.demo.android.ui

import com.example.demo.data.model.Pokedex

sealed class PokedexScreenState {
    object Loading : PokedexScreenState()

    object Error : PokedexScreenState()

    class ShowPokedex(val pokedex : Pokedex) : PokedexScreenState()
}