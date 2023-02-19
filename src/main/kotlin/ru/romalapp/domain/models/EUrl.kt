package ru.romalapp.domain.models

enum class EUrl (val enumUrl: String){
    JSON("https://api2.kiparo.com/static/it_news.json"),
    XML("https://api2.kiparo.com/static/it_news.xml")
}