package com.example.kudonavdrawerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.model.Faq

class FAQAdapter(private val versionList: ArrayList<Faq>) :
    RecyclerView.Adapter<FAQAdapter.VersionHolder>() {
    class VersionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lnContent: LinearLayout = itemView.findViewById(R.id.ln_content)
        var tvContent: TextView = itemView.findViewById(R.id.tv_content)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        var imgExpandMore: ImageView = itemView.findViewById(R.id.img_expand)
        var imgExpandLess: ImageView = itemView.findViewById(R.id.img_expand_less)
        var constrain: ConstraintLayout = itemView.findViewById(R.id.constrain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_faq, parent, false)
        val expandLess = view.findViewById<ImageView>(R.id.img_expand_less)
        expandLess.visibility = View.GONE

        return VersionHolder(view)
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    override fun onBindViewHolder(holder: VersionHolder, position: Int) {
        val version = versionList[position]
        holder.tvTitle.text = version.title
        holder.tvContent.text = version.content
        holder.imgExpandMore.setImageResource(R.drawable.expand_more)
        holder.imgExpandLess.setImageResource(R.drawable.expand_less)


        val isExpandable: Boolean = versionList[position].expandable
        holder.lnContent.visibility = if (isExpandable) View.VISIBLE else View.GONE
        val result = holder.lnContent.visibility
        holder.constrain.setOnClickListener {
            val versions = versionList[position]
            versions.expandable = !versions.expandable
            notifyItemChanged(position)
        }
        if (result == 0x00000004) {
            holder.imgExpandMore.visibility = View.VISIBLE
            holder.imgExpandLess.visibility = View.GONE
        } else if (result == 0x00000000) {
            holder.imgExpandMore.visibility = View.GONE
            holder.imgExpandLess.visibility = View.VISIBLE
        }

    }
}