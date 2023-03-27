package com.example.musicwiki.network.retrofit


import com.example.musicwiki.dataclasses.*
import com.example.musicwiki.models.response.artist.TopArtistsModel
import com.example.musicwiki.models.response.albumInfo.AlbumInfomodel
import com.example.musicwiki.models.response.albums.AlbumsModel
import com.example.musicwiki.models.response.artistInfo.ArtistInfoModel
import com.example.musicwiki.models.response.artistTopAlbumsFinal.ArtistTopAlbumsFinal
import com.example.musicwiki.models.response.artistTopTracks.ArtistTopTracksModel
import com.example.musicwiki.models.response.genreInfo.GenreInfoResponse
import com.example.musicwiki.models.response.genres.Genres
import com.example.musicwiki.models.response.toptracks.TopTracksModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LastfmApi {


    @GET("/2.0")
    suspend fun getTopTags(
        @Query("method") method:String="tag.getTopTags",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ): Response<Genres>

    @GET("/2.0")
    suspend fun getTagInfo(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getInfo",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ): Response<GenreInfoResponse>

    @GET("/2.0")
    suspend fun getTopAlbums(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopAlbums",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ): Response<AlbumsModel>

    @GET("/2.0")
    suspend fun getTopArtists(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopArtists",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ): Response<TopArtistsModel>

    @GET("/2.0")
    suspend fun getTopTracks(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopTracks",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ) : Response<TopTracksModel>

    @GET("/2.0")
    suspend fun getAlbumInfo(
        @Query("artist")artist:String,
        @Query("album")album:String,
        @Query("method") method:String="album.getInfo",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ) : Response<AlbumInfomodel>


    @GET("/2.0")
    suspend fun getArtistInfo(
        @Query("artist")artist:String,
        @Query("method") method:String="artist.getInfo",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ) : Response<ArtistInfoModel>


    @GET("/2.0")
    suspend fun getArtistTopAlbums(
        @Query("artist") artist:String,
        @Query("method") method:String="artist.getTopAlbums",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ): Response<ArtistTopAlbumsFinal>

    @GET("/2.0")
    suspend fun getArtistTopTracks(
        @Query("artist") artist:String,
        @Query("method") method:String="artist.getTopTracks",
        @Query("api_key") apiKey:String="f0ac8d674b4e448f433063d612936822",
        @Query("format") format:String="json"
    ) : Response<ArtistTopTracksModel>

}