package com.example.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.CardItemBinding
import com.example.musicwiki.models.response.albumInfo.Album
import com.example.musicwiki.models.response.artistTopAlbumsFinal.ArtistTopAlbumItem
import com.example.musicwiki.screens.activities.AlbumDetailActivity
import com.example.musicwiki.utils.showImage

class ArtistTopAlbumsAdapter(var mContext: Context): RecyclerView.Adapter<ArtistTopAlbumsAdapter.ArtistTopAlbumsViewHolder>() {
    inner class ArtistTopAlbumsViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    var artistTopAlbums : List<ArtistTopAlbumItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistTopAlbumsViewHolder {
        return ArtistTopAlbumsViewHolder(CardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ArtistTopAlbumsViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = artistTopAlbums[position].name
            itemArtistName.text = artistTopAlbums[position].artist.name
            //itemImg.showImage(artistTopAlbums[position].image[0].text)
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, AlbumDetailActivity::class.java)
            mIntent.putExtra("albumName",artistTopAlbums[position].name)
            mIntent.putExtra("artistName",artistTopAlbums[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return artistTopAlbums.size
    }
}

