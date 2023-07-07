package com.example.demo.domain

import PokedexRepositoryDB
import com.example.demo.data.model.PokedexResults
import com.example.demo.data.remote.PokedexRepositoryApi
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class PokedexServices() {

 //   private val repoDba=PokedexRepositoryDB() deberia usar hilt
    private val repoApi = PokedexRepositoryApi()

    suspend fun getPokedexFromApi(): HttpResponse {
        return repoApi.get()
    }

  /*  fun insertPokedex(pokedex: List<PokedexResults>){
        repoDba.insertPokedexs(pokedex)

    }*/

  /*  suspend fun getPokedexFromDB():List<PokedexResults>{
        return PokedexRepositoryDB().get()
   }*/
}