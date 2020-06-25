package com.ihaha.sunny.fox.local.entity.categories

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ihaha.sunny.fox.local.entity.comment.CommentatorsData
import com.ihaha.sunny.fox.local.entity.tags.TagsData
import com.ihaha.sunny.fox.local.entity.user.UserData
import org.jetbrains.annotations.NotNull

@Entity(tableName = "editors_choice", primaryKeys = ["id"])
data class EditorsChoice(
    @NotNull
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "url")
    var url: String = "",
    @ColumnInfo(name = "user_id")
    var user_Id: String = "",
    @ColumnInfo(name = "contents_short")
    var contentsShort: String = "",
    @ColumnInfo(name = "published_at")
    var publishedAt: String = "",
    @ColumnInfo(name = "is_published")
    var isPublished: Boolean = true,
    @ColumnInfo(name = "updated_at")
    var updatedAt: String = "",
    @ColumnInfo(name = "reading_time")
    var readingTime: String = "0",
    @ColumnInfo(name = "points")
    var points: String = "0",
    @ColumnInfo(name = "views_count")
    var viewsCount: String = "0",
    @ColumnInfo(name = "clips_count")
    var clipsCount: String = "0",
    @ColumnInfo(name = "comments_count")
    var commentsCount: String = "0",
    @ColumnInfo(name = "rated_varue")
    var ratedValue: String = "",
    @ColumnInfo(name = "thumbnail_url")
    var thumbnailUrl: String = "",

    @Embedded
    var user: UserData? = null,
    @Embedded
    var tags: TagsData? = null,
    @Embedded
    var commentators: ArrayList<CommentatorsData>? = null
)