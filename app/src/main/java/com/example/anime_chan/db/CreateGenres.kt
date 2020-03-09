package com.example.anime_chan.db

class CreateGenres {
    companion object
    private

    val GenreIdList = listOf(
        "Action",
        "Adventure",
        "Cars",
        "Comedy",
        "Dementia",
        "Demons",
        "Mystery",
        "Drama",
        "Ecchi",
        "Fantasy",
        "Game",
        "Hentai",
        "Historical",
        "Horror",
        "Kids",
        "Magic",
        "Martial Arts",
        "Mecha",
        "Music",
        "Parody",
        "Samurai",
        "Romance",
        "School",
        "Sci Fi",
        "Shoujo",
        "Shoujo Ai",
        "Shounen",
        "Shounen Ai",
        "Space",
        "Sports",
        "Super Power",
        "Vampire",
        "Yaoi",
        "Yuri",
        "Harem",
        "Slice Of Life",
        "Supernatural",
        "Military",
        "Police",
        "Psychological",
        "Seinen",
        "Josei",
        "Doujinshi",
        "Gender Bender",
        "Thriller"
    )

    fun getGenreIds(): List<String> = GenreIdList

}