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
import com.example.newwavesell.model.Pro

class CartFragment : Fragment(), OnItemClickListener {
    private val cartList = generateList()
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
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView?.adapter = adapter
            recyclerView?.layoutManager = LinearLayoutManager(context)
        return view
    }

    private fun generateList(): ArrayList<Pro> {
        val list = ArrayList<Pro>()
        for (i in 0..2) {
            val itemPro = Pro("T-shirt $i", 100, "L", R.color.colorPrimary, 1000, "5/4/1999")
            list += itemPro
        }
        return list
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
    }

}