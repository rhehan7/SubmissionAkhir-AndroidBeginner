package com.dicoding.desawisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.desawisata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Village>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTouristVillages.setHasFixedSize(true)

        list.addAll(getListVillages())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListVillages(): ArrayList<Village> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataUniqueVillage = resources.getStringArray(R.array.data_unique_village)
        val listVillages = ArrayList<Village>()
        for (i in dataName.indices) {
            val village = Village(
                dataPhoto.getResourceId(i, -1),
                dataName[i],
                dataDescription[i],
                dataLocation[i],
                dataUniqueVillage[i]
            )
            listVillages.add(village)
        }
        return listVillages
    }

    private fun showRecyclerList() {
        binding.rvTouristVillages.layoutManager = LinearLayoutManager(this)
        val listVillageAdapter = ListVillageAdapter(list)
        binding.rvTouristVillages.adapter = listVillageAdapter

        // Menggunakan lambda untuk handle item click
        listVillageAdapter.onItemClick = { village ->
            val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_VILLAGE, village)
            startActivity(moveWithObjectIntent)
        }
    }
}