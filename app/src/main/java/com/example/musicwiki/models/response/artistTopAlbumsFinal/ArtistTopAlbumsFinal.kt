package com.example.musicwiki.models.response.artistTopAlbumsFinal

import com.google.gson.annotations.SerializedName

data class ArtistTopAlbumsFinal(

	@field:SerializedName("topalbums")
	val topalbums: Topalbums
)

data class Artist(

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class Topalbums(

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("album")
	val album: List<ArtistTopAlbumItem>
)

data class Attr(

	@field:SerializedName("total")
	val total: String,

	@field:SerializedName("perPage")
	val perPage: String,

	@field:SerializedName("artist")
	val artist: String,

	@field:SerializedName("totalPages")
	val totalPages: String,

	@field:SerializedName("page")
	val page: String
)

data class ArtistTopAlbumItem(

	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("artist")
	val artist: Artist,

	@field:SerializedName("playcount")
	val playcount: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("mbid")
	val mbid: String
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("size")
	val size: String
)
