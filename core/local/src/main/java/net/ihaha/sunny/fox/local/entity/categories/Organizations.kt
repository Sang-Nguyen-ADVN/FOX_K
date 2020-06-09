package net.ihaha.sunny.fox.local.entity.categories


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.ihaha.sunny.fox.local.entity.comment.Commentators
import net.ihaha.sunny.fox.local.entity.comment.CommentatorsData
import net.ihaha.sunny.fox.local.entity.tags.Tags
import net.ihaha.sunny.fox.local.entity.tags.TagsData
import net.ihaha.sunny.fox.local.entity.user.User
import net.ihaha.sunny.fox.local.entity.user.UserData
import org.jetbrains.annotations.NotNull

@Entity(tableName = "organizations", primaryKeys = ["id"])
data class Organizations(
    @NotNull
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "user_id")
    var userId: Int = 0,
    @ColumnInfo(name = "avatar")
    var avatar: String = "",
    @ColumnInfo(name = "slug")
    var slug: String = "",
    @ColumnInfo(name = "following")
    var following: Boolean,
    @ColumnInfo(name = "followers_count")
    var followersCount: Int = 0,
    @ColumnInfo(name = "location")
    var location: String = "",
    @ColumnInfo(name = "posts_count")
    var postsCount: Int = 0,
    @ColumnInfo(name = "members_count")
    var membersCount: Int = 0,
    @ColumnInfo(name = "google_analytics_id")
    var googleAnalyticsId: String = "",
    @ColumnInfo(name = "short_description")
    var shortDescription: String = "",
    @ColumnInfo(name = "full_description")
    var fullDescription: String = "",
    @ColumnInfo(name = "approved")
    var approved: Boolean,
    @ColumnInfo(name = "website")
    var website: String = "",

    @Embedded
    var user: UserData? = null,
    @Embedded
    var tags: TagsData? = null,
    @Embedded
    var commentators: ArrayList<CommentatorsData>? = null
)