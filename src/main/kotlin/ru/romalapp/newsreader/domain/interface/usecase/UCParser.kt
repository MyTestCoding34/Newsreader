package ru.romalapp.newsreader.domain.`interface`.usecase

interface UCParser {
    fun execute(dataString: String, keyword: String = "")
}