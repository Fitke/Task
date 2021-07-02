package com.example.task

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.api.entities.Feature
import com.example.task.ui.MapsActivity
import kotlinx.android.synthetic.main.feature_list_layout.view.*

class FeatureAdapter : RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    private var featureList: MutableList<Feature> = mutableListOf()

    fun updateList(newFeatures: List<Feature>){
        featureList.clear()
        featureList.addAll(newFeatures)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.feature_list_layout, parent, false)

        return  FeatureViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        val currentItem = featureList[position]

        holder.tvID.text = currentItem.id.toString()
    }

    override fun getItemCount() = featureList.size

    inner class FeatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvID: TextView = itemView.tvID

        init {
            itemView.setOnClickListener {v: View ->
                val position: Int = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    val intent = Intent(v.context, MapsActivity::class.java)
                    intent.putParcelableArrayListExtra("points", ArrayList(featureList[position].points))
                    v.context.startActivity(intent)
                }
            }
        }
    }

}