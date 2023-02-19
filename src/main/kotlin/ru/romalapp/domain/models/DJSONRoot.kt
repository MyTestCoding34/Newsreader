package ru.romalapp.domain.models

data class DJSONRoot(
    val name: String,
    val location: String,
    val news: List<DJSONNews>
)
