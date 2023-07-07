package com.example.demo.data.remote

import com.example.demo.data.model.Pokedex

interface PokedexRepository {
    suspend fun get(): Pokedex
}