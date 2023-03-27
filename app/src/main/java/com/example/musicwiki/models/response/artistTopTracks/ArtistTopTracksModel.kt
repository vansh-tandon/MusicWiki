package com.example.musicwiki.models.response.artistTopTracks

import com.google.gson.annotations.SerializedName

data class ArtistTopTracksModel(

	@field:SerializedName("toptracks")
	val toptracks: Toptracks? = null
)



data class TrackItem(

	@field:SerializedName("image")
	val image: List<ImageItem?>? = null,

	@field:SerializedName("@attr")
	val attr: Attr? = null,

	@field:SerializedName("mbid")
	val mbid: String? = null,

	@field:SerializedName("listeners")
	val listeners: String? = null,

	@field:SerializedName("streamable")
	val streamable: String? = null,

	@field:SerializedName("artist")
	val artist: Artist? = null,

	@field:SerializedName("playcount")
	val playcount: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String? = null,

	@field:SerializedName("size")
	val size: String? = null
)

data class Artist(

	@field:SerializedName("mbid")
	val mbid: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Toptracks(

	@field:SerializedName("@attr")
	val attr: Attr? = null,

	@field:SerializedName("track")
	val track: List<TrackItem?>? = null
)

data class Attr(

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("perPage")
	val perPage: String? = null,

	@field:SerializedName("artist")
	val artist: String? = null,

	@field:SerializedName("totalPages")
	val totalPages: String? = null,

	@field:SerializedName("page")
	val page: String? = null,

	@field:SerializedName("rank")
	val rank: String? = null
)
