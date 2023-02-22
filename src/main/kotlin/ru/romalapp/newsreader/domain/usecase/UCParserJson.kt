package ru.romalapp.newsreader.domain.usecase

import com.google.gson.Gson
import com.google.gson.JsonParseException
import ru.romalapp.newsreader.domain.`interface`.usecase.UCParser
import ru.romalapp.newsreader.domain.models.DJSONRoot
import ru.romalapp.newsreader.domain.dll.ReplaceDate

class UCParserJson: UCParser {
    override fun execute(dataString: String, keyword: String) {
        val gson = Gson()
        val dJsonRoot: DJSONRoot
        try {
            dJsonRoot = gson.fromJson(dataString, DJSONRoot::class.java)
        } catch (e: JsonParseException) {
            println("Что то пошло не так! Крашнулся парсер Json!")
            println()
            return
        }

        val sortNews = dJsonRoot.news.filter { it.visible && (keyword == "" || it.keywords.contains(keyword)) }
            .sortedBy { it.date }
        if (sortNews.isNotEmpty()) {
            for (news in sortNews) {
                println("Id: ${news.id}")
                println("Title: ${news.title}")
                println("Description: ${news.description}")
                println("Date: ${ReplaceDate.execute(news.date)}")
                println("Keywords: ${news.keywords.joinToString(", ")}")
                println()
            }
        } else {
            println("По вашему запросу новостей не найдено!")
            println()
        }
    }
}