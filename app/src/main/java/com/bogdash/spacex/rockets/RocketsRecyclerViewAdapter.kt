package com.bogdash.spacex.rockets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bogdash.spacex.R

class RocketsRecyclerViewAdapter(private val rockets: ArrayList<Rocket>) :
    RecyclerView.Adapter<RocketsRecyclerViewAdapter.RocketsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RocketsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rocket, parent, false)
        return RocketsViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: RocketsViewHolder,
        position: Int
    ) {
        val currentItem = rockets[position]
        holder.picture.setImageResource(currentItem.picture)
        holder.rocket.text = currentItem.rocket
        holder.rocketName.text = currentItem.rocketName
        holder.isActiveTitle.text = currentItem.isActiveTitle

        val colorStateList = ContextCompat.getColorStateList(
            holder.itemView.context,
            if (currentItem.isActive) R.color.green else R.color.red
        )
        holder.cardViewRockets.setCardBackgroundColor(colorStateList)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    class RocketsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.iv_picture_rockets)
        val rocket: TextView = itemView.findViewById(R.id.tv_rocket_name_rockets)
        val rocketName: TextView = itemView.findViewById(R.id.tv_rocket_name_rockets)
        val isActiveTitle: TextView = itemView.findViewById(R.id.tv_active_rockets)
        val cardViewRockets: CardView = itemView.findViewById(R.id.card_view_rockets)
    }
}