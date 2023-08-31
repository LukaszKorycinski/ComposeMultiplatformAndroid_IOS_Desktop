package data.repository

import data.api.clients.WeatherApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepository(
    private val weatherApiClient: WeatherApiClient,
): WeatherRepositoryInterface {

//    override suspend fun getCityAutocomplete(query: String): Flow<SafeResponse<List<CityResponseItem>>> =
//        flow {
//            emit(safeApiCall {
//                weatherApiClient.getCityAutocomplete(
//                    query = query,
//                )
//            })
//        }
//
//    override suspend fun getForecast(locationKey: String): Flow<SafeResponse<ForecastResponse>> =
//        flow {
//            emit(safeApiCall {
//                weatherApiClient.getForecast(
//                    locationKey = locationKey,
//                )
//            })
//        }

}