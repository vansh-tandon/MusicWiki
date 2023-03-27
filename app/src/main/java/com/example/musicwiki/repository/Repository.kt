package com.example.musicwiki.repository


import com.example.musicwiki.models.response.artist.TopArtistsModel
import com.example.musicwiki.models.response.albumInfo.AlbumInfomodel
import com.example.musicwiki.models.response.albums.AlbumsModel
import com.example.musicwiki.models.response.artistInfo.ArtistInfoModel
import com.example.musicwiki.models.response.artistTopAlbumsFinal.ArtistTopAlbumsFinal
import com.example.musicwiki.models.response.artistTopTracks.ArtistTopTracksModel
import com.example.musicwiki.models.response.genreInfo.GenreInfoResponse
import com.example.musicwiki.models.response.genres.Genres
import com.example.musicwiki.models.response.toptracks.TopTracksModel
import com.example.musicwiki.network.retrofit.RetrofitInstance
import retrofit2.Response


class Repository {

    suspend fun getTopTags(): Response<Genres> {
        return RetrofitInstance.api.getTopTags()
    }

    suspend fun getTagInfo(tag:String): Response<GenreInfoResponse> {
        return RetrofitInstance.api.getTagInfo(tag)
    }

    suspend fun getTagAlbum(tag:String): Response<AlbumsModel> {
        return RetrofitInstance.api.getTopAlbums(tag)
    }

    suspend fun getTagArtist(tag:String): Response<TopArtistsModel> {
        return RetrofitInstance.api.getTopArtists(tag)
    }

    suspend fun getTagTracks(tag: String): Response<TopTracksModel> {
        return RetrofitInstance.api.getTopTracks(tag)
    }

    suspend fun getAlbumInfo(artist:String, album:String): Response<AlbumInfomodel> {
        return RetrofitInstance.api.getAlbumInfo(artist, album )
    }

    suspend fun getArtistInfo(artist: String): Response<ArtistInfoModel> {
        return RetrofitInstance.api.getArtistInfo(artist)
    }


    suspend fun getArtistTopAlbums(artist: String):Response<ArtistTopAlbumsFinal>{
        return RetrofitInstance.api.getArtistTopAlbums(artist)
    }

    suspend fun getArtistTopTracks(artist: String): Response<ArtistTopTracksModel> {
        return RetrofitInstance.api.getArtistTopTracks(artist)
    }
}