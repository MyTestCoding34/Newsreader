package ru.romalapp.domain.models

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "root")
data class DXMLRoot(
    @JacksonXmlProperty(localName = "location")
    val location: String,
    @JacksonXmlProperty(localName = "name")
    val name: String,
    @JacksonXmlProperty(localName = "news")
    val news: DXMLRootElement
)