package com.ihaha.sunny.fox.local.entity.posts


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.ihaha.sunny.fox.local.entity.user.UserPost
import org.jetbrains.annotations.NotNull

@Entity(tableName = "post_item", primaryKeys = ["id"])
data class PostsItem(
    @NotNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "title")
    var title: String? = "",
    @ColumnInfo(name = "canonical_url")
    var canonicalUrl: String? = "",
    @ColumnInfo(name = "path")
    var path: String? = "",
    @Embedded
    @ColumnInfo(name = "user")
    var user: UserPost? = null
)