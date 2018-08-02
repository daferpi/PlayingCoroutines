package com.projects.abelfernandez.playingcoroutines.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item
import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface GithubApi {

    companion object {
        fun create(baseUrl:String ="https://api.github.com"):GithubApi {
            val client = OkHttpClient
                    .Builder()
                    .addInterceptor(
                            HttpLoggingInterceptor()
                                    .apply {
                                        level = HttpLoggingInterceptor.Level.BODY
                                    }
                    )
                    .build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                    .addConverterFactory(ScalarsConverterFactory.create())//Needed to handle HTML String responses
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl(baseUrl)
                    .build()

            return retrofit.create(GithubApi::class.java)
        }
    }



    @GET("/repositories")
    fun findAllRepositories():Deferred<Response<List<Item>>>
}