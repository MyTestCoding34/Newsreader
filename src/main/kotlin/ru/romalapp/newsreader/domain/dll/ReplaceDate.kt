package ru.romalapp.newsreader.domain.dll

import java.text.SimpleDateFormat
import java.util.*

object ReplaceDate {
    fun execute(date: String): String {
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.getDefault())
        val outputDateFormat = SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.getDefault())
        val inputDate = inputDateFormat.parse(date)
        return outputDateFormat.format(inputDate)
    }
}