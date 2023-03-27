package com.example.musicwiki.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

//    Application name	MusicWiki
//    API key	f0ac8d674b4e448f433063d612936822
//    Shared secret	b5e2ac84062752b749539446a4231278
//    Registered to	vanshtandon

    val api : LastfmApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LastfmApi::class.java)
    }
}