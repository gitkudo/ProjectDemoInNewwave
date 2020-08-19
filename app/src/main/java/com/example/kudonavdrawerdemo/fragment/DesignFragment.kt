package com.example.kudonavdrawerdemo.fragment

import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.`interface`.*
import com.example.kudonavdrawerdemo.adapter.BirdAdapter
import com.example.kudonavdrawerdemo.adapter.CatAdapter
import com.example.kudonavdrawerdemo.model.*
import com.example.newwavesell.model.ItemBelow
import com.example.newwavesell.ui.design.*
import kotlinx.android.synthetic.main.activity_main.*


class DesignFragment : Fragment(), OnItemClickListener, ElephantItemClickListener,HorseItemClickListener,DogItemClickListener,CatItemClickListener,BirdItemClickListener {
    lateinit var rcvAbove: RecyclerView
    lateinit var rvBelow: RecyclerView
    lateinit var imgShow: ImageView

    //below recycleView
    private var list = ArrayList<ItemBelow>()
    private val belowAdapter = DesignBelowAdapter(list, this)

    //elephant recycleView
    private var listElephant = ArrayList<Elephant>()
    private val elephantAdapter = ElephantAdapter(listElephant, this)

    // horse RecycleView
    private var listHorse = ArrayList<Horse>()
    private val horseAdapter = HorseAdapter(listHorse, this)

    // horse RecycleView
    private var listDog = ArrayList<Dog>()
    private val dogAdapter = DogAdapter(listDog, this)

    // horse RecycleView
    private var listCat = ArrayList<Cat>()
    private val catAdapter = CatAdapter(listCat,this)

    // horse RecycleView
    private var listBird = ArrayList<Bird>()
    private val birdAdapter = BirdAdapter(listBird, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_design, container, false)
        imgShow = view.findViewById(R.id.img_show)
        val imgBack = view?.findViewById<ImageView>(R.id.imgBack)
        imgBack?.setOnClickListener { activity?.onBackPressed() }
        rcvAbove = view.findViewById(R.id.rcvStyleAbove)!!
        //rcvBelow
        rvBelow = view?.findViewById(R.id.rcvStyle)!!
        initElephantRcv()
        initBelowRcv()
        return view
    }

    private fun initBelowRcv() {
        if (rvBelow != null) {
            rvBelow.adapter = belowAdapter
        }
        if (rvBelow != null) {
            rvBelow.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rvBelow?.setHasFixedSize(true)
        list.add(ItemBelow(R.drawable.ic_elephant, "elephant"))
        list.add(ItemBelow(R.drawable.ic_horse, "horse"))
        list.add(ItemBelow(R.drawable.ic_dog, "dog"))
        list.add(ItemBelow(R.drawable.ic_cat, "cat"))
        list.add(ItemBelow(R.drawable.ic_bird, "bird"))

    }

    private fun initElephantRcv() {
        listElephant.clear()
        imgShow.colorFilter = null
        Handler().postDelayed(Runnable {
            imgShow.setImageDrawable(resources.getDrawable(R.drawable.ic_elephant))

        }, 100)



        if (rcvAbove != null) {
            rcvAbove.adapter = elephantAdapter
        }
        if (rcvAbove != null) {
            rcvAbove.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rcvAbove?.setHasFixedSize(true)
        listElephant.add(Elephant(R.drawable.ic_ele_colo, "Gray"))
        listElephant.add(Elephant(R.drawable.ic_ele_green, "Green"))
        listElephant.add(Elephant(R.drawable.ic_ele_yellow, "Yellow"))
    }

    private fun initHorseRcv() {
        listHorse.clear();
        imgShow.setImageResource(R.drawable.horse_imagepng)
        imgShow.setColorFilter(null)

        if (rcvAbove != null) {
            rcvAbove.adapter = horseAdapter
        }
        if (rcvAbove != null) {
            rcvAbove.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rcvAbove?.setHasFixedSize(true)
        listHorse.add(Horse(R.drawable.ic_red, "Red"))
        listHorse.add(Horse(R.drawable.ic_blue, "Blue"))
        listHorse.add(Horse(R.drawable.ic_green, "Green"))
        listHorse.add(Horse(R.drawable.ic_yellow, "Yellow"))
    }
    private fun initCatRcv() {
        listCat.clear();
        imgShow.setImageResource(R.drawable.ic_cat)
        imgShow.colorFilter = null

        if (rcvAbove != null) {
            rcvAbove.adapter = catAdapter
        }
        if (rcvAbove != null) {
            rcvAbove.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rcvAbove?.setHasFixedSize(true)
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Red"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Blue"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Green"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Yellow"))
    }
    private fun initDogRcv() {
        listDog.clear();
        imgShow.setImageResource(R.drawable.ic_dog)
        imgShow.setColorFilter(null)

        if (rcvAbove != null) {
            rcvAbove.adapter = dogAdapter
        }
        if (rcvAbove != null) {
            rcvAbove.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rcvAbove?.setHasFixedSize(true)
        listDog.add(Dog(R.drawable.ic_dog_black, "Red"))
        listDog.add(Dog(R.drawable.ic_dog_black, "Blue"))
        listDog.add(Dog(R.drawable.ic_dog_black, "Green"))
    }

    fun open1(){

    }
    private fun initBirdRcv() {
        listBird.clear();
        imgShow.setImageResource(R.drawable.ic_bird)
        imgShow.setColorFilter(null)

        if (rcvAbove != null) {
            rcvAbove.adapter = birdAdapter
        }

        if (rcvAbove != null) {
            rcvAbove.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        rcvAbove?.setHasFixedSize(true)
        listBird.add(Bird(R.drawable.ic_bird_gray, "Red"))
        listBird.add(Bird(R.drawable.ic_bird_gray, "Blue"))
        listBird.add(Bird(R.drawable.ic_bird_gray, "Green"))
        listBird.add(Bird(R.drawable.ic_bird_gray, "Yellow"))
    }

    override fun onItemClick(position: Int) {
        when (position) {
            0 -> initElephantRcv()
            1 -> initHorseRcv()
            2 -> initDogRcv()
            3 -> initCatRcv()
            4 -> initBirdRcv()
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return DesignFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.nav_view?.visibility = View.GONE
    }

    override fun onEleItemClick(position: Int) {
        when (position) {
            0 -> imgShow.setImageResource(R.drawable.ic_ele_colo)
            1 -> imgShow.setImageResource(R.drawable.ic_ele_green)
            2 -> imgShow.setImageResource(R.drawable.ic_ele_yellow)
        }
    }

    override fun horseItemClick(position: Int) {
        when(position){
            0 -> imgShow.setImageResource(R.drawable.ic_red)
            1 -> imgShow.setImageResource(R.drawable.ic_blue)
            2 -> imgShow.setImageResource(R.drawable.ic_green)
            3 -> imgShow.setImageResource(R.drawable.ic_yellow)
        }
    }

    override fun dogItemClick(position: Int) {

    }

    override fun catItemClick(position: Int) {
        TODO("Not yet implemented")
    }

    override fun birdItemClick(position: Int) {
        TODO("Not yet implemented")
    }


}