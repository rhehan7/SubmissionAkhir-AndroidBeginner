package com.dicoding.desawisata

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.desawisata.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_VILLAGE = "extra_village"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataVillage = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Village>(EXTRA_VILLAGE, Village::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Village>(EXTRA_VILLAGE)
        }

        // menampilkan data pada UI
        dataVillage?.let {
            binding.villageImage.setImageResource(it.photo)
            binding.villageName.text = it.name
            binding.villageDescription.text = it.description
            binding.villageLocation.text = it.location
            binding.villageCharm.text = it.uniqueDetails
        }
        // implementasi fungsi share // menampilkan aksi pada action share ketika di klik
        binding.actionShare.setOnClickListener {
            dataVillage?.let { village ->
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Jelajahi Desa ${village.name}: ${village.description}"
                    )
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Bagikan Desa ${village.name}"))
            }
        }
    }
}