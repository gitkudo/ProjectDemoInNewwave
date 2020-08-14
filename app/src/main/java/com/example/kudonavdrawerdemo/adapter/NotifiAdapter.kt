package com.example.kudonavdrawerdemo.adapter

import android.graphics.LightingColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.kudonavdrawerdemo.model.Nontifi
import com.example.newwavesell.model.Pro
import org.w3c.dom.Text

class NotifiAdapter(
    private val nonList: ArrayList<Nontifi>,
    private val listen: OnItemClickListener

) : RecyclerView.Adapter<NotifiAdapter.NotifiHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifiAdapter.NotifiHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nontifi, parent, false)
        return NotifiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nonList.size
    }

    override fun onBindViewHolder(holder: NotifiAdapter.NotifiHolder, position: Int) {
        val currentItem = nonList[position]
        holder.tv_title!!.text = currentItem.title
        holder.tv_content!!.text = currentItem.content
//        holder.tvColor?.setImageResource(R.color.colorAccent)
    }

    inner class NotifiHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!),
        View.OnClickListener {
        val tv_title = itemView?.findViewById<TextView>(R.id.tv_title)
        val tv_content = itemView?.findViewById<TextView>(R.id.tv_content)

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listen.onItemClick(position)
            }

        }
    }
}