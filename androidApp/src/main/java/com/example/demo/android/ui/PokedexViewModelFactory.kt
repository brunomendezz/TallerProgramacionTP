package com.example.demo.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demo.domain.PokedexServices

class PokedexViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val pokedexRepository = PokedexServices()

        return PokedexViewModel(pokedexRepository) as T
    }
}