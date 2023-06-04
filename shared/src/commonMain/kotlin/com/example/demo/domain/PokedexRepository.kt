package com.example.demo.domain

import com.example.demo.data.remote.PokedexRepositoryApi
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class PokedexRepository {

    suspend fun getPokedex(): HttpResponse? {
        try {
            val response: HttpResponse = PokedexRepositoryApi.httpClient.get("https://pokeapi.co/api/v2/pokemon/?limit=800")
            if (response.status == HttpStatusCode.OK) {
                return response
            }
        } catch (e: Exception) {
            // Manejar la excepción apropiadamente
            e.printStackTrace()
        } finally {
            PokedexRepositoryApi.httpClient.close()
        }

        return null
    }
}