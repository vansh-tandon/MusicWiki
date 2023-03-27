package com.example.musicwiki.screens.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.adapters.AlbumInfoGenreAdapter
import com.example.musicwiki.databinding.ActivityAlbumDetailBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.utils.showImage
import com.example.musicwiki.viewmodels.MainViewModel
import com.example.musicwiki.viewmodels.ViewModelFactoryMain

class AlbumDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumDetailBinding
    lateinit var albumInfoGenreAdapter: AlbumInfoGenreAdapter
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        val aints = intent
        val aname = aints.getStringExtra("albumName")
        val arname = aints.getStringExtra("artistName")


        val repository = Repository()
        val viewModelFactory = ViewModelFactoryMain(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAlbumInfo(arname.toString(), aname.toString())
        viewModel.albumInfoResponse.observe(this) { info ->

            setUpRecyclerView()
            binding.albumTitle.text = info.name
            binding.artistTitle.text = info.artist
            binding.albumDesc.text = info.wiki?.summary
            binding.albumImg.showImage(info.image[0].text)
        }
    }

    private fun setUpRecyclerView()  = binding.albumInfoGenreRv.apply {
        albumInfoGenreAdapter = AlbumInfoGenreAdapter(this@AlbumDetailActivity)
        adapter = albumInfoGenreAdapter
        layoutManager = LinearLayoutManager(this@AlbumDetailActivity, LinearLayoutManager.HORIZONTAL,false)
    }

}
