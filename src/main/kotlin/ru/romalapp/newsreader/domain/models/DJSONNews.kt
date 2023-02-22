package ru.romalapp.newsreader.domain.models

data class DJSONNews(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val keywords: List<String>,
    val visible: Boolean
)
