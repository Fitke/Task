package com.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.FeatureAdapter
import com.example.task.R
import com.example.task.api.ApiService
import com.example.task.api.Repository.FeatureListRepository
import kotlinx.android.synthetic.main.activity_list_of_features.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FeaturesListActivity : AppCompatActivity() {

    private lateinit var viewModel: FeatureListViewModel
    private var adapter = FeatureAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_features)

        val service = ApiService()
        val repository = FeatureListRepository(service)
        val factory = FeatureViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(FeatureListViewModel::class.java)
        bindUI()
        observeFeatures()
    }

    private fun bindUI() = GlobalScope.launch(Dispatchers.Main) {
        rcList.adapter = adapter
        rcList.setHasFixedSize(true)
        rcList.layoutManager = LinearLayoutManager(this@FeaturesListActivity)
    }
    private fun observeFeatures() {
        viewModel.features.observe(this, Observer { features ->
            features?.let {
                adapter.updateList(it.features)
            }
        })
    }
}