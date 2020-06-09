package net.ihaha.sunny.fox.local

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.ihaha.sunny.fox.local.entity.categories.*
import net.ihaha.sunny.fox.local.entity.tags.Tags
import net.ihaha.sunny.fox.local.entity.user.User
import net.ihaha.sunny.fox.local.room.*

/**
 * Created by Sunny on 9/29/2019.
 * Version 1.0
 */

@Database(
    entities = [
        Newest::class,
        Videos::class,
        Trending::class,
        EditorsChoice::class,
        User::class,
        Tags::class,
        Series::class,
        Organizations::class
    ],
    version = BuildConfig.FOX_DATABASE_VERSION, exportSchema = BuildConfig.FOX_DATABASE_EXPORT_SCHEMA
)

abstract class AppDatabase() : RoomDatabase() {
    abstract fun newestDao(): NewestDao
    abstract fun videosDao(): VideosDao
    abstract fun trendingDao(): TrendingDao
    abstract fun editorsChoiceDao(): EditorsChoiceDao
    abstract fun tagsDao(): TagsDao
    abstract fun seriesDao(): SeriesDao
    abstract fun organizationsDao() : OrganizationsDao
}