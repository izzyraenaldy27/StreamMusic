package com.pab.streammusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pab.streammusic.adapter.SongsListAdapter
import com.pab.streammusic.databinding.ActivitySongsListBinding
import com.pab.streammusic.models.CategoryModel

class SongsListActivity : AppCompatActivity() {

    companion object{
        lateinit var category : CategoryModel
    }

    lateinit var  binding: ActivitySongsListBinding
    lateinit var songsListAdapter: SongsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTextView.text  = category.name
        Glide.with(binding.coverImageView).load(category.coverUrl)
            .apply(
                RequestOptions().transform(RoundedCorners(32))
            )
            .into(binding.coverImageView)


        setupSongsListRecyclerView()
    }

    fun setupSongsListRecyclerView(){
        songsListAdapter = SongsListAdapter(category.songs)
        binding.songsListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.songsListRecyclerView.adapter = songsListAdapter
    }

}


















