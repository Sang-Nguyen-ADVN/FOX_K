package com.ihaha.sunny.fox.domain.model.home

data class Categories (
    var id: String,
    var title: String = "",
    var url: String = "",
    var user_Id: String = "",
    var contentsShort: String = "",
    var publishedAt: String = "",
    var isPublished: Boolean = true,
    var updatedAt: String = "",
    var readingTime: String = "0",
    var points: String = "0",
    var viewsCount: String = "0",
    var clipsCount: String = "0",
    var commentsCount: String = "0",
    var ratedValue: String = "",
    var thumbnailUrl: String = ""

//    var user: UserData? = null,
//    var tags: TagsData? = null,
//    var commentators: ArrayList<CommentatorsData>? = null

)