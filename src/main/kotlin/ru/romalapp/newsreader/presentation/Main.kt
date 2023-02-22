@file:JvmName("Main")

package ru.romalapp.newsreader.presentation

import ru.romalapp.newsreader.domain.`interface`.usecase.UCParser
import ru.romalapp.newsreader.domain.models.DReturnAnswerData
import ru.romalapp.newsreader.domain.models.EUrl
import ru.romalapp.newsreader.domain.usecase.*

fun main() {
    var papseApi: EUrl = EUrl.JSON
    var inputText = ""
    var answerDataText = ""
    var answerData: DReturnAnswerData

    println("Для завершения работы приложения введите \"exit\"")
    while (inputText != "exit") {
        println("Нажмите 1 что-бы скачать JSON, 2 - XML")
        inputText = readlnOrNull().toString()

        if (!(inputText == "1" || inputText == "2"))
            continue
        papseApi = if (inputText == "1") {
            EUrl.JSON
        } else {
            EUrl.XML
        }
        println("Выполняется запрос...")
        answerData = UCRequest().execute(papseApi)
        answerDataText = answerData.answerData
        if (!answerData.isError) {
            inputText = "next"
        } else {
            println(answerDataText)
        }
        if (inputText == "next")
            break
    }

    val parser: UCParser = if (papseApi == EUrl.JSON) {
        UCParserJson()
    } else {
        UCParserXml()
    }

    while (inputText != "exit") {
        println("1 - вывести все новости, 2 - поиск по keyword")
        inputText = readlnOrNull().toString()
        if (inputText == "1") {
            parser.execute(answerDataText)
        } else if (inputText == "2") {
            println("Введите слова для поиска")
            inputText = readlnOrNull().toString()
            parser.execute(answerDataText, inputText)
        }
    }
}
