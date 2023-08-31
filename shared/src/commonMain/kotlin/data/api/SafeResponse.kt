package data.api

import data.api.models.response.ErrorResponse
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.json.Json

sealed interface SafeResponse<T> {
    data class Success<T>(val data: T) : SafeResponse<T>
    class Error<T>(val errorType: ErrorType, val throwable: Throwable? = null, val message: String? = null) :
        SafeResponse<T>
    class Loading<T>: SafeResponse<T>
}

enum class ErrorType {
    NETWORK, DATA
}

//suspend fun <T> safeApiCall(block: suspend () -> HttpResponse<T>): SafeResponse<T> {
//    return try {
//        val response = block()
//        val body = response.body()
//
//        if (body != null) {
//            SafeResponse.Success(body)
//        } else {
//            //Timber.w("error API call - missing data body")
//
//            val errorBody = response.errorBody()?.string()
//            errorBody?.let {
////                val jsonSerializer = get<Json>(Json::class.java)
////                val errorResponseBody = jsonSerializer.decodeFromString<ErrorResponse>(it)
////                SafeResponse.Error(errorType = ErrorType.DATA, message = errorResponseBody.message)
//            } ?: SafeResponse.Error(errorType = ErrorType.DATA)
//        }
//    } catch (e: Throwable) {
//        if (e is IOException) {
//            //Timber.w(e, "error API call - network issue")
//            SafeResponse.Error(errorType = ErrorType.NETWORK, e)
//        } else {
//            //Timber.w(e, "error API call - incorrect data/other")
//            SafeResponse.Error(errorType = ErrorType.DATA, e)
//        }
//    }
//
//}