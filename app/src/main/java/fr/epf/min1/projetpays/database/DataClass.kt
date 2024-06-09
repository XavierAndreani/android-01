package fr.epf.min1.projetpays.database

data class Country(
    val name: Name,
    val flags: Flags,
    val capital: List<String>?,
    val region: String,
    val subregion: String,
    val population: Int,
    val languages: Map<String, String>
)

data class Name(
    val common: String,
    val official: String
)

data class Flags(
    val png: String,
    val svg: String
)
