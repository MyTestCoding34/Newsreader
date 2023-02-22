@file:JvmName("Main")
package ru.romalapp.presentation

import ru.romalapp.domain.models.DReturnAnswerData
import ru.romalapp.domain.usecase.UCParserJson
import ru.romalapp.domain.usecase.UCParserXml
import ru.romalapp.domain.usecase.UCRequestJson
import ru.romalapp.domain.usecase.UCRequestXml

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
            answerData = UCRequestJson().execute()
            answerDataText = answerData.answerData
            if (!answerData.isError){
                inputText = "next"
            }
            else{
                println(answerDataText)
            }
        }
        else if (inputText == "2"){
            println("Выполняется запрос...")
            answerData = UCRequestXml().execute()
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
//    while (inputText != "exit") {
//        println("1 - вывести все новости, 2 - поиск по keyword")
//        inputText = readlnOrNull().toString()
//        if (inputText == "1"){
//            UCParserJson().execute(answerDataText)
//        }
//        else if ( inputText == "2"){
//            println("Введите слова для поиска")
//            inputText = readlnOrNull().toString()
//            UCParserJson().execute(answerDataText, inputText)
//        }
//    }

    while (inputText != "exit") {
        println("1 - вывести все новости, 2 - поиск по keyword")
        inputText = readlnOrNull().toString()
        if (inputText == "1"){
            UCParserXml().execute(answerDataText)
        }
        else if ( inputText == "2"){
            println("Введите слова для поиска")
            inputText = readlnOrNull().toString()
            UCParserXml().execute(answerDataText, inputText)
        }
    }
}