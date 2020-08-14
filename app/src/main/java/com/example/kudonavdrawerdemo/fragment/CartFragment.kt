package com.example.kudonavdrawerdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.OnItemClickListener
import com.example.kudonavdrawerdemo.adapter.CartListAdapter
import com.example.kudonavdrawerdemo.adapter.ListProAdapter
import com.example.newwavesell.model.Pro

class CartFragment : Fragment(), OnItemClickListener {
    private val cartList = generateList(2)
    private val adapter = CartListAdapter(cartList, this)

    companion object {
        fun newInstance(): Fragment {
            return CartFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_cart, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        if (recyclerView != null) {
            recyclerView.adapter = adapter
        }
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        return view
    }

    private fun generateList(size: Int): ArrayList<Pro> {
        val list = ArrayList<Pro>()
        for (i in 0..size) {
            val itemPro = Pro("T-shirt $i", 100, "L", R.color.colorPrimary, 1000, "5/4/1999")
            list += itemPro
        }
        return list
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
    }

}