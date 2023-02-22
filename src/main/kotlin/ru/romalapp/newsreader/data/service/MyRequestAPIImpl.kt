package ru.romalapp.newsreader.data.service

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
import ru.romalapp.newsreader.domain.models.DReturnAnswerData
import ru.romalapp.newsreader.domain.models.EUrl
import ru.romalapp.newsreader.domain.`interface`.service.MyRequestAPI

class MyRequestAPIImpl : MyRequestAPI {

    override fun execute(url: EUrl): DReturnAnswerData {
        var answerAPIText: String
        var noErrors = false
        try {
            answerAPIText = requestAPI(url)

        } catch (e: Exception){
            answerAPIText = "Ошибка HTTP запроса. Повторите попытку позже!"
            noErrors = true
        }
        return DReturnAnswerData(isError = noErrors, answerData = answerAPIText)
    }

    private fun requestAPI(url: EUrl): String{
        val client = OkHttpClient
            .Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url(url.enumUrl)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64)")
            .addHeader("Connection", "close")
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body()?.string() ?: ""
        response.close()
        if (!response.isSuccessful){
            throw Exception("Ошибка HTTP запроса. Повторите попытку позже!")
        }
        return responseBody
    }
}
