package com.dicoding.desawisata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.desawisata.databinding.ActivityAboutBinding
import com.dicoding.desawisata.databinding.ActivityDetailBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "About Me"
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}