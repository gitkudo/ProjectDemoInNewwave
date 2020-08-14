package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.model.Faq

class FAQAdapter(val versionList: ArrayList<Faq>) :
    RecyclerView.Adapter<FAQAdapter.VersionHolder>() {
    class VersionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ln_content = itemView.findViewById<LinearLayout>(R.id.ln_content)
        var tv_content = itemView.findViewById<TextView>(R.id.tv_content)
        var tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        var img_expand_more = itemView.findViewById<ImageView>(R.id.img_expand)
        var img_expand_less = itemView.findViewById<ImageView>(R.id.img_expand_less)
        var constrain = itemView.findViewById<ConstraintLayout>(R.id.constrain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_faq, parent, false)
        val expandLess = view.findViewById<ImageView>(R.id.img_expand_less)
        expandLess.visibility = View.GONE

        return VersionHolder(view)
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    override fun onBindViewHolder(holder: VersionHolder, position: Int) {
        val version = versionList[position]
        holder.tv_title.text = version.title
        holder.tv_content.text = version.content
        holder.img_expand_more.setImageResource(R.drawable.expand_more)
        holder.img_expand_less.setImageResource(R.drawable.expand_less)


        val isExpandable: Boolean = versionList[position].expandable
        holder.ln_content.visibility = if (isExpandable) View.VISIBLE else View.GONE
        var result = holder.ln_content.visibility
        holder.constrain.setOnClickListener {
            val versions = versionList[position]
            versions.expandable = !versions.expandable
            notifyItemChanged(position)
        }
        if (result == 0x00000004) {
            holder.img_expand_more.visibility = View.VISIBLE
            holder.img_expand_less.visibility = View.GONE
        } else if (result == 0x00000000) {
            holder.img_expand_more.visibility = View.GONE
            holder.img_expand_less.visibility = View.VISIBLE
        }

    }
}