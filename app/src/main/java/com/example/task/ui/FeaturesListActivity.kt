package com.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import retrofit2.awaitResponse

class FeaturesListActivity : AppCompatActivity() {

    private lateinit var viewModel: FeatureListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_features)

        val service = ApiService()
        val repository = FeatureListRepository(service)
        val factory = FeatureViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(FeatureListViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = GlobalScope.launch(Dispatchers.Main) {
        rcList.apply {

            val featureData = viewModel.getFeatureList.await()
            layoutManager = LinearLayoutManager(this@FeaturesListActivity)
            adapter = FeatureAdapter(featureData.awaitResponse().body()!!.features)
            setHasFixedSize(true)
        }
    }
}