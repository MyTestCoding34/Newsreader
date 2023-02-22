package ru.romalapp.domain.usecase

import ru.romalapp.data.MyRequestAPIImpl
import ru.romalapp.domain.models.DReturnAnswerData
import ru.romalapp.domain.models.EUrl
/*
Класс для получения ответа от сервера в формате Json или ошибки
 */
class UCRequestJson {
    fun execute(): DReturnAnswerData {
        return MyRequestAPIImpl().execute(EUrl.JSON)
    }
}