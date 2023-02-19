package ru.romalapp.domain.models

interface MyRequestAPI {
    fun execute (url: EUrl):DReturnAnswerData
}