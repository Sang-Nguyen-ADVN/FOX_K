package net.ihaha.sunny.fox.local.entity.posts


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import net.ihaha.sunny.fox.local.entity.tags.Tags
import net.ihaha.sunny.fox.local.entity.user.User

@Entity(tableName = "posts" , primaryKeys = ["_posts_id"])
data class Posts(
    @NonNull
    @ColumnInfo(name = "_posts_id")
    var id: Int,
    @ColumnInfo(name = "_posts_title")
    var title: String? = "",
    @ColumnInfo(name = "_posts_canonical_url")
    var canonicalUrl: String? = "",
    @ColumnInfo(name = "_posts_path")
    var path: String? = "",
    @Embedded
    var user: User? = null,
    @Embedded
    var tags: ArrayList<Tags>? = null
)