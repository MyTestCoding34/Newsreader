package ru.romalapp.newsreader.domain.`interface`.service

import ru.romalapp.newsreader.domain.models.DReturnAnswerData
import ru.romalapp.newsreader.domain.models.EUrl

interface MyRequestAPI {
    fun execute (url: EUrl): DReturnAnswerData
}