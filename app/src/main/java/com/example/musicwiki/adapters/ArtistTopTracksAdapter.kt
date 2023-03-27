package com.example.musicwiki.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.CardItemBinding
import com.example.musicwiki.models.response.artistTopTracks.TrackItem
import com.example.musicwiki.utils.showImage

class ArtistTopTracksAdapter : RecyclerView.Adapter<ArtistTopTracksAdapter.AristTopTracksViewHolder>() {
    inner class AristTopTracksViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    var artistInfoTopTracks : List<TrackItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AristTopTracksViewHolder {
        return AristTopTracksViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: AristTopTracksViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = artistInfoTopTracks[position].name
            itemArtistName.text = (artistInfoTopTracks[position].artist?.name ?: Log.d("imageLink",
                artistInfoTopTracks[position].image?.get(0)?.text?.toString()!!
            )).toString()
            //itemImg.showImage(artistInfoTopTracks[position].image?.get(0)?.text)
        }
    }

    override fun getItemCount(): Int {
        return artistInfoTopTracks.size
    }
}
