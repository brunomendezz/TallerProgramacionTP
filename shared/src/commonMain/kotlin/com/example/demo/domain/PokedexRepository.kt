package com.example.demo.domain

import com.example.demo.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokedexRepository {

    val httpClient= HttpClient {
        install(Logging){
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpCLient", message=message)
                }
            }
        }
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys=true
                }
            )
        }
    }.also {
        initLogger()
    }

    suspend fun getPokedex(): HttpResponse? {
        try {
            val response: HttpResponse = httpClient.get("https://pokeapi.co/api/v2/pokemon/?limit=800")
            if (response.status == HttpStatusCode.OK) {
                return response
            }
        } catch (e: Exception) {
            // Manejar la excepción apropiadamente
            e.printStackTrace()
        } finally {
            httpClient.close()
        }

        return null
    }
}