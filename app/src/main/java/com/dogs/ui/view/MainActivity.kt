package com.dogs.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View.GONE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogs.R
import com.dogs.databinding.ActivityMainBinding
import com.dogs.ui.Adapter.DogAdapter
import com.dogs.ui.viewModel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: DogAdapter

    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchViewDogs.setOnQueryTextListener(this)
        dogViewModel.onCreate()

        dogViewModel.dogsModel.observe(this, Observer {
            adapter = DogAdapter(it.dogImages)
            binding.rvDogs.layoutManager = LinearLayoutManager(this)
            binding.rvDogs.adapter = adapter
        })

        dogViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        dogViewModel.rvVisibility.observe(this, Observer {
            binding.rvDogs.isVisible = it
        })

        dogViewModel.messageList.observe(this, Observer {
            if (it != null) {
                adapter = DogAdapter(it.dogImages)
                binding.rvDogs.layoutManager = LinearLayoutManager(this)
                binding.rvDogs.adapter = adapter
            } else {
              Toast.makeText(this, R.string.empty, Toast.LENGTH_LONG).show()
            }

        })

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
//            dogViewModel.getBreeds(query.lowercase(Locale.getDefault()))
            dogViewModel.getBreeds(query.toLowerCase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean { return false}
}