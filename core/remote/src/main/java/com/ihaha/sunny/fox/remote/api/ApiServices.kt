package com.ihaha.sunny.fox.remote.api

import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Deferred
import com.ihaha.sunny.fox.remote.BuildConfig
import com.ihaha.sunny.fox.remote.Constants
import com.ihaha.sunny.fox.remote.models.base.ErrorResponse
import com.ihaha.sunny.fox.remote.models.categories.*
import com.ihaha.sunny.fox.remote.models.tags.Tags
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiServices {

    @GET(BuildConfig.FOX_API_BASE_POST + Constants.STRUCTURE.DOMAIN.NEWEST)
    fun getNewestAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Newest>, ErrorResponse>>

    @GET(BuildConfig.FOX_API_BASE_POST + Constants.STRUCTURE.DOMAIN.EDITORS_CHOICE)
    fun getEditorChoiceAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<EditorsChoice>, ErrorResponse>>

    @GET(BuildConfig.FOX_API_BASE_POST + Constants.STRUCTURE.DOMAIN.TRENDING)
    fun getTrendingAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Trending>, ErrorResponse>>

    @GET(BuildConfig.FOX_API_BASE_POST + Constants.STRUCTURE.DOMAIN.VIDEOS)
    fun getVideoAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Videos>, ErrorResponse>>

    @GET(Constants.STRUCTURE.DOMAIN.SERIES)
    fun getSeriesAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Series>, ErrorResponse>>

    @GET(Constants.STRUCTURE.DOMAIN.ORGANIZATIONS)
    fun getOrganizationsAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Organizations>, ErrorResponse>>

    @GET(Constants.STRUCTURE.DOMAIN.TAGS)
    fun getTagsAsync(@QueryMap hashMap: HashMap<String, String> = HashMap()) : Deferred<NetworkResponse<List<Tags>, ErrorResponse>>
}