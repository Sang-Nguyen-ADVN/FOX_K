package net.ihaha.sunny.fox.remote.di

import android.content.Context
import com.google.gson.Gson
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.ihaha.sunny.fox.remote.BuildConfig
import net.ihaha.sunny.fox.remote.api.ApiServices
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


/**
 * Created by Sunny on 9/27/2019.
 * Version 1.0
 */

val networkModule = module {

    fun createOkHttpCache(context: Context): Cache =
        Cache(context.cacheDir, (10 * 1024 * 1024).toLong())

    fun createLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }


    fun createHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .build()
            val newRequest = request.newBuilder()
                .url(newUrl)
                .method(request.method, request.body)
                .build()
            chain.proceed(newRequest)
        }

    single { createOkHttpCache(get()) }

    single(named("logging")) { createLoggingInterceptor() }

//    single(named("header")) { createHeaderInterceptor() }

    single {
        OkHttpClient.Builder()
            .cache(get<Cache>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.FOX_API_BASE_URL + BuildConfig.FOX_API_BASE_API )
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }

    single {
        get<Retrofit>().create(ApiServices::class.java)
    }



}