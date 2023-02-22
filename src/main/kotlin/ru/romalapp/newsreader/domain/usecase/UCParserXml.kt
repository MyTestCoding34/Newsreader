package ru.romalapp.newsreader.domain.usecase

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.JsonParseException
import ru.romalapp.newsreader.domain.dll.ReplaceDate
import ru.romalapp.newsreader.domain.`interface`.usecase.UCParser
import ru.romalapp.newsreader.domain.models.DXMLRoot

class UCParserXml: UCParser {
    override fun execute(dataString: String, keyword: String) {
        val mapper = XmlMapper()
        val xmlRoot: DXMLRoot
        try {
            xmlRoot = mapper.readValue(dataString, DXMLRoot::class.java)
        } catch (e: JsonParseException) {
            println("Что то пошло не так! Крашнулся парсер XML!")
            println()
            return
        }
        val sortNews = xmlRoot.news.element.filter { it.visible && (keyword == "" || it.keywords.contains(keyword)) }
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