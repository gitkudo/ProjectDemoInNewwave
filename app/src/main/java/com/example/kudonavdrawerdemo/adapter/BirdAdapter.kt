package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.BirdItemClickListener
import com.example.kudonavdrawerdemo.`interface`.ElephantItemClickListener
import com.example.kudonavdrawerdemo.model.Bird
import kotlin.collections.ArrayList

class BirdAdapter(
    private val BirdAdapter: ArrayList<Bird>,
    private val listener: BirdItemClickListener
) : RecyclerView.Adapter<BirdAdapter.LogoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LogoHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoHolder(view)
    }

    inner class LogoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imgLogo: ImageView = itemView.findViewById(R.id.imgColor)
        var tv_name: TextView = itemView.findViewById(R.id.tv_name)

        init {

            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.birdItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return BirdAdapter.size
    }

    override fun onBindViewHolder(holder: LogoHolder, position: Int) {
        var itemLogo = BirdAdapter[position]
        holder.imgLogo.setImageResource(itemLogo.image)
        holder.tv_name.text = itemLogo.name
    }
}