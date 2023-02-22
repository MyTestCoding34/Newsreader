package ru.romalapp.newsreader.domain.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "element")
data class DXMLNews(
    @JacksonXmlProperty(localName = "date")
    val date: String,
    @JacksonXmlProperty(localName = "description")
    val description: String,
    @JacksonXmlProperty(localName = "id")
    val id: Int,
    @JacksonXmlProperty(localName = "keywords")
    val keywords: List<String>,
    @JacksonXmlProperty(localName = "title")
    val title: String,
    @JacksonXmlProperty(localName = "visible")
    val visible: Boolean
)
