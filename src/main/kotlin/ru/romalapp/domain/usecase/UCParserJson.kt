package ru.romalapp.domain.usecase

import com.google.gson.Gson
import com.google.gson.JsonParseException
import ru.romalapp.domain.models.DJSONRoot
import java.text.SimpleDateFormat
import java.util.*

class UCParserJson {
    fun parserJSONToList(jsonString: String, keyword: String = "") {
        val gson = Gson()
        val dJsonRoot: DJSONRoot
        try {
            dJsonRoot = gson.fromJson(jsonString, DJSONRoot::class.java)
        } catch (e: JsonParseException) {
            println("Что то пошло не так! Крашнулся парсер Json!")
            println()
            return
        }

//        val sortNews = dJsonRoot.news.sortedBy { news -> news.date }
        val sortNews = dJsonRoot.news.filter { it.visible && (keyword == "" || it.keywords.contains(keyword)) }
            .sortedBy { it.date }
        if (sortNews.isNotEmpty()) {
            for (news in sortNews) {
                println("Id: ${news.id}")
                println("Title: ${news.title}")
                println("Description: ${news.description}")
                println("Date: ${formatDate(news.date)}")
                println("Keywords: ${news.keywords.joinToString(", ")}")
                println()
            }
        } else {
            println("По вашему запросу новостей не найдено!")
            println()
        }
    }

    private fun formatDate(date: String): String {
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.getDefault())
        val outputDateFormat = SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.getDefault())
        val inputDate = inputDateFormat.parse(date)
        return outputDateFormat.format(inputDate)
    }
}