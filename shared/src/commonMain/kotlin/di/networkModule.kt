package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    single {
        HttpClient{
            install(ContentNegotiation) {
                get<Json>()
            }
        }
    }

    single {
        Json {
            ignoreUnknownKeys = true
            explicitNulls = false
            isLenient = true
        }
    }
}