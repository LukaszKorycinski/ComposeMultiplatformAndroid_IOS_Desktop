package data.api.clients

import MyApplication.shared.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class WeatherApiClient(private val client: HttpClient) {

    suspend fun getCities(
        apiKey: String = BuildConfig.API_KEY,
        query: String,
        language: String = "pl-pl",
    ): HttpResponse = client.get(BuildConfig.BASE_URL+"locations/v1/cities/search") {
        parameter("apiKey",apiKey)
        parameter("q",query)
        parameter("language",language)
    }

    suspend fun getCityAutocomplete(
        apiKey: String = BuildConfig.API_KEY,
        query: String,
        language: String = "pl-pl",
    ): HttpResponse = client.get(BuildConfig.BASE_URL+"locations/v1/cities/autocomplete") {
        parameter("apiKey",apiKey)
        parameter("q", query)
        parameter("language", language)
    }

    suspend fun getForecast(
        apiKey: String = BuildConfig.API_KEY,
        query: String,
        language: String = "pl-pl",
    ): HttpResponse = client.get(BuildConfig.BASE_URL+"forecasts/v1/daily/5day/") {
        parameter("apiKey",apiKey)
        parameter("q", query)
        parameter("language", language)
    }

//    @GET("locations/v1/cities/autocomplete")
//    suspend fun getCityAutocomplete(
//        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
//        @Query("q") query: String,
//        @Query("language") language: String = "pl-pl",
//    ): Response<List<CityResponseItem>>
//
//    @GET("forecasts/v1/daily/5day/{locationKey}")
//    suspend fun getForecast(
//        @Path("locationKey") locationKey: String,
//        @Query("apikey") apiKey: String = BuildConfig.API_KEY,
//        @Query("language") language: String = "pl-pl",
//    ): Response<ForecastResponse>
}