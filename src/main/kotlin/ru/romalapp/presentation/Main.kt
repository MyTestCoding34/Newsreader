@file:JvmName("Main")
package ru.romalapp.presentation

import ru.romalapp.domain.models.DReturnAnswerData
import ru.romalapp.domain.usecase.UCParserJson
import ru.romalapp.domain.usecase.UCRequestJson

fun main() {

    var answerData: DReturnAnswerData
    var answerDataText = ""

    var inputText = ""
    println("Для завершения работы приложения введите \"exit\"")
    println("Для возврата в основное меню введите \"start\"")
    while (inputText != "exit") {
        println("Нажмите 1 что-бы скачать JSON, 2 - XML")
        inputText = readlnOrNull().toString()
       if (inputText == "1"){
           println("Выполняется запрос...")
            answerData = UCRequestJson().executeAPI()
            answerDataText = answerData.answerData
            if (!answerData.isError){
                inputText = "next"
            }
            else{
                println(answerDataText)
            }
        }

        if (inputText == "next")
            break
    }
    while (inputText != "exit") {
        println("1 - вывести все новости, 2 - поиск по keyword")
        inputText = readlnOrNull().toString()
        if (inputText == "1"){
            UCParserJson().parserJSONToList(answerDataText)
        }
        else if ( inputText == "2"){
            println("Введите слова для поиска")
            inputText = readlnOrNull().toString()
            UCParserJson().parserJSONToList(answerDataText, inputText)
        }
    }
}