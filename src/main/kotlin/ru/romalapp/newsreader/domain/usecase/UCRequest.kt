package ru.romalapp.newsreader.domain.usecase

import ru.romalapp.newsreader.data.service.MyRequestAPIImpl
import ru.romalapp.newsreader.domain.models.DReturnAnswerData
import ru.romalapp.newsreader.domain.models.EUrl

class UCRequest {
    fun execute(url: EUrl): DReturnAnswerData {
        return MyRequestAPIImpl().execute(url)
    }
}