package com.example.musicwiki.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenreItemBinding
import com.example.musicwiki.models.response.genres.TagItem
import com.example.musicwiki.screens.activities.GenresInformationActivity

class TopGenreAdapter(var mContext: Context) : RecyclerView.Adapter<TopGenreAdapter.TopGenreViewHolder>() {

    inner class TopGenreViewHolder(val binding: GenreItemBinding) : RecyclerView.ViewHolder(binding.root)

    var genres: List<TagItem> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopGenreViewHolder {
        return TopGenreViewHolder(GenreItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TopGenreViewHolder, position: Int) {
      holder.binding.apply {
          val genre = genres[position]
          genreName.text = genres[position].name
      }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, GenresInformationActivity::class.java)
            mIntent.putExtra("NAME",genres[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
      return genres.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataset(dataList: MutableList<TagItem>) {
        genres = dataList
        notifyDataSetChanged()
    }
}
