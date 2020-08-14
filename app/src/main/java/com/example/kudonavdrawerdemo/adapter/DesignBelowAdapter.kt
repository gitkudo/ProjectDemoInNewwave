package com.example.newwavesell.ui.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.newwavesell.model.ItemBelow

class DesignBelowAdapter(
    private val itemBelowList: List<ItemBelow>,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<DesignBelowAdapter.BelowHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BelowHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_below, parent, false)
        return BelowHolder(view)
    }

    override fun getItemCount(): Int {
        return itemBelowList.size
    }

    override fun onBindViewHolder(holder: BelowHolder, position: Int) {
        var imgItem = itemBelowList[position]
        holder.imgIcon.setImageResource(imgItem.image)
        holder.tv_name.text = imgItem.name
    }

    inner class BelowHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imgIcon = itemView.findViewById<ImageView>(R.id.imgIconBelow)
        var tv_name = itemView.findViewById<TextView>(R.id.tv_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                itemClickListener.onItemClick(position)
            }
        }
    }
}