package com.example.musicwiki.screens.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapters.AlbumInfoGenreAdapter
import com.example.musicwiki.adapters.ArtistTopAlbumsAdapter
import com.example.musicwiki.adapters.ArtistTopTracksAdapter
import com.example.musicwiki.databinding.ActivityArtistDetailBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.utils.showImage
import com.example.musicwiki.viewmodels.MainViewModel
import com.example.musicwiki.viewmodels.ViewModelFactoryMain

class ArtistDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistDetailBinding
    lateinit var albumInfoGenreAdapter: AlbumInfoGenreAdapter
    lateinit var artistTopTracksAdapter: ArtistTopTracksAdapter
    lateinit var artistTopAlbumsAdapter: ArtistTopAlbumsAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detail)

        binding = ActivityArtistDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        setUpRecyclerView1()
        setUpRecyclerView2()

        val aints = intent
        val aname = aints.getStringExtra("albumName")
        val arname = aints.getStringExtra("artistName")

        val repository = Repository()
        val viewModelFactory = ViewModelFactoryMain(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getArtistInfo(arname.toString())
        viewModel.artistInfoResponse.observe(this) { response ->

            setUpRecyclerView()

//         albumInfoGenreAdapter.albumInfoGenre = response.tags.tag.
            binding.artistTitle.text = response.name
            binding.artistPlaycount.text = response.stats.playcount
            binding.artistListeners.text = response.stats.listeners
            binding.artistImg.showImage(response.image[0].text)

            viewModel.getArtistTopTracks(arname.toString())
            viewModel.artistTopTracksResponse.observe(this) { topTracks ->
                setUpRecyclerView1()
                artistTopTracksAdapter.artistInfoTopTracks = topTracks
            }

            viewModel.getArtistTopAlbums(arname.toString())
            viewModel.artistTopAlbumsResponse.observe(this){
                setUpRecyclerView2()
                artistTopAlbumsAdapter.artistTopAlbums = it
            }

        }


    }

    private fun setUpRecyclerView()  = binding.artistInfoGenreRv.apply {
        albumInfoGenreAdapter = AlbumInfoGenreAdapter(this@ArtistDetailActivity)
        adapter = albumInfoGenreAdapter
        layoutManager = LinearLayoutManager(this@ArtistDetailActivity, LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setUpRecyclerView1() = binding.artistInfoToptracksRv.apply {
        artistTopTracksAdapter = ArtistTopTracksAdapter()
        adapter = artistTopTracksAdapter
        layoutManager = LinearLayoutManager(this@ArtistDetailActivity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpRecyclerView2() = binding.artistInfoTopalbumsRv.apply {
        artistTopAlbumsAdapter = ArtistTopAlbumsAdapter(this@ArtistDetailActivity)
        adapter = artistTopAlbumsAdapter
        layoutManager = LinearLayoutManager(this@ArtistDetailActivity, LinearLayoutManager.HORIZONTAL, false)
    }

}