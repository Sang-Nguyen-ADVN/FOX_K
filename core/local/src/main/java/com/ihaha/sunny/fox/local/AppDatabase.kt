package com.ihaha.sunny.fox.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ihaha.sunny.fox.local.entity.categories.*
import com.ihaha.sunny.fox.local.entity.organizations.Organizations
import com.ihaha.sunny.fox.local.entity.series.Series
import com.ihaha.sunny.fox.local.entity.tags.Tags
import com.ihaha.sunny.fox.local.entity.user.User
import com.ihaha.sunny.fox.local.room.categories.EditorsChoiceDao
import com.ihaha.sunny.fox.local.room.categories.NewestDao
import com.ihaha.sunny.fox.local.room.categories.TrendingDao
import com.ihaha.sunny.fox.local.room.categories.VideosDao
import com.ihaha.sunny.fox.local.room.organization.OrganizationsDao
import com.ihaha.sunny.fox.local.room.series.SeriesDao
import com.ihaha.sunny.fox.local.room.tags.TagsDao

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