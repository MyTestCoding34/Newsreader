package ru.romalapp.domain.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "news")
data class DXMLRootElement(
    @JacksonXmlProperty(localName = "element")
    @JacksonXmlElementWrapper(useWrapping = false)
    val element: List<DXMLNews> = arrayListOf()
)
