package com.bogdash.spacex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaunchesRecyclerViewAdapter(private val rockets: ArrayList<Rocket>) : RecyclerView.Adapter<LaunchesRecyclerViewAdapter.LaunchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false)
        return LaunchesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val currentItem = rockets[position]
        holder.picture.setImageResource(currentItem.picture)
        holder.launch.text = currentItem.launch
        holder.rocketName.text = currentItem.rocketName
        holder.complex.text = currentItem.complex
        holder.date.text = currentItem.date
    }

    class LaunchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.iv_picture)
        val launch: TextView = itemView.findViewById(R.id.tv_launch)
        val rocketName: TextView = itemView.findViewById(R.id.tv_rocket_name)
        val complex: TextView = itemView.findViewById(R.id.tv_complex)
        val date: TextView = itemView.findViewById(R.id.tv_date)
    }
}