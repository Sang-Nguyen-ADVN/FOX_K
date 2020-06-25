package com.ihaha.sunny.fox.local.entity.tags


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tags", primaryKeys = ["_tag_id"])
data class Tags(
    @NotNull
    @ColumnInfo(name = "_tag_id")
    var id: String,
    @ColumnInfo(name = "_tag_slug")
    var slug: String? = "",
    @ColumnInfo(name = "_tag_url")
    var url: String? = "",
    @ColumnInfo(name = "_tag_primary")
    var primary: Boolean? = true,
    @ColumnInfo(name = "_tag_name")
    var name: String? = "",
    @ColumnInfo(name = "_tag_posts_count")
    var postsCount: String? = "",
    @ColumnInfo(name = "_tag_questions_count")
    var questionsCount: String? = "",
    @ColumnInfo(name = "_tag_followers_count")
    var followersCount: String? = "",
    @ColumnInfo(name = "_tag_image")
    var image: String? = ""
)