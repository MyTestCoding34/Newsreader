package ru.romalapp.domain.usecase


import com.fasterxml.jackson.dataformat.xml.XmlMapper
import ru.romalapp.domain.models.DXMLRoot
import java.text.SimpleDateFormat
import java.util.*

class UCParserXml {
    fun execute(xmlString: String, keyword: String = "") {
        val mapper = XmlMapper()
        val xmlRoot = mapper.readValue(xmlString, DXMLRoot::class.java)
        val sortNews = xmlRoot.news.element.filter { it.visible && (keyword == "" || it.keywords.contains(keyword)) }
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