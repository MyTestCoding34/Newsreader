package ru.romalapp.domain.usecase

import ru.romalapp.data.MyRequestAPIImpl
import ru.romalapp.domain.models.DReturnAnswerData
import ru.romalapp.domain.models.EUrl
/*
Класс для получения ответа от сервера в формате xml или ошибки
 */
class UCRequestXml {
    fun executeAPI(): DReturnAnswerData {
        return MyRequestAPIImpl().execute(EUrl.XML)
    }
}