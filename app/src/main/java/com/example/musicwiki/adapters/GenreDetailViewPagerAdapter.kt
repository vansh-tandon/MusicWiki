package com.example.musicwiki.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musicwiki.screens.fragments.GenreAlbumsFragment
import com.example.musicwiki.screens.fragments.GenreArtistsFragment
import com.example.musicwiki.screens.fragments.GenreTracksFragment

class GenreDetailViewPagerAdapter(fragmentActivity: FragmentActivity, var name:String) : FragmentStateAdapter(fragmentActivity){


    override fun getItemCount(): Int {
      return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> GenreAlbumsFragment(name)
            1-> GenreArtistsFragment(name)
            2-> GenreTracksFragment(name)
            else->{
                GenreAlbumsFragment(name)
            }
        }
    }

}