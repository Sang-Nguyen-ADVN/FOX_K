package net.ihaha.sunny.fox.local.entity.search


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.ihaha.sunny.fox.local.entity.tags.Tags
import net.ihaha.sunny.fox.local.entity.user.User
import org.jetbrains.annotations.NotNull

@Entity(tableName = "search", primaryKeys = ["id"])
data class Search(
    @NotNull
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "points")
    var points: String = "0",
    @ColumnInfo(name = "published_at")
    var publishedAt: String = "",
    @ColumnInfo(name = "rated_varue")
    var ratedValue: String = "",
    @ColumnInfo(name = "slug")
    var slug: String = "",
    @ColumnInfo(name = "system")
    var system: String = "",
    @ColumnInfo(name = "teaser")
    var teaser: String = "",
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "transliterated")
    var transliterated: String = "",
    @ColumnInfo(name = "type")
    var type: String = "",
    @Embedded(prefix = "user")
    @ColumnInfo(name = "user")
    var user: User? = null,
    @Embedded(prefix = "tags")
    @ColumnInfo(name = "tags")
    var tags: ArrayList<Tags>? = null
)