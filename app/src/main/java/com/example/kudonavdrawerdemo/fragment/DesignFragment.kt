package com.example.kudonavdrawerdemo.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kudonavdrawerdemo.R
import com.example.kudonavdrawerdemo.inter.*
import com.example.kudonavdrawerdemo.adapter.BirdAdapter
import com.example.kudonavdrawerdemo.adapter.CatAdapter
import com.example.kudonavdrawerdemo.adapter.ElephantAdapter
import com.example.kudonavdrawerdemo.adapter.HorseAdapter
import com.example.kudonavdrawerdemo.model.*
import com.example.kudonavdrawerdemo.sellrealm.manager.ProductRealmManager
import com.example.newwavesell.model.ItemBelow
import com.example.newwavesell.ui.design.*
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_product.*
import java.util.*
import kotlin.collections.ArrayList

interface CallBack {
    fun dialogOnClick(name: String, amount: Int, proSize: String, color: Int, upTime: String)
}

class DesignFragment : Fragment(), OnItemClickListener, ElephantItemClickListener,
    HorseItemClickListener, DogItemClickListener, CatItemClickListener, BirdItemClickListener,
    CallBack {
    private lateinit var rcvAbove: RecyclerView
    private lateinit var rvBelow: RecyclerView
    private lateinit var imgShow: ImageView
    private val manager = ProductRealmManager()
    lateinit var realm: Realm;

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
    private val catAdapter = CatAdapter(listCat, this)

    // horse RecycleView
    private var listBird = ArrayList<Bird>()
    private val birdAdapter = BirdAdapter(listBird, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_design, container, false)
        realm = Realm.getDefaultInstance()
        imgShow = view.findViewById(R.id.img_show)
        val btnAddToCart: Button = view.findViewById(R.id.btn_addToCart)
        val imgBack = view?.findViewById<ImageView>(R.id.imgBack)
        imgBack?.setOnClickListener { activity?.onBackPressed() }
        rcvAbove = view.findViewById(R.id.rcvStyleAbove)!!
        //rcvBelow
        rvBelow = view?.findViewById(R.id.rcvStyle)!!
        initElephantRcv()
        initBelowRcv()
        btnAddToCart.setOnClickListener {
            showDialog(this)
        }
        return view
    }

    private fun showDialog(callBack: CallBack) {
        val buider = AlertDialog.Builder(context)
        buider.setTitle("Describe Product")
        buider.setCancelable(true)
        val mDialog = LayoutInflater.from(context).inflate(R.layout.dialog_add_product, null)
        buider.setView(mDialog)
        val edtName:EditText = mDialog.findViewById(R.id.edt_name)
        val edtAmount:EditText = mDialog.findViewById(R.id.edt_amout)
        val edtProSize:EditText = mDialog.findViewById(R.id.edt_prosize)
        val edtColor:EditText = mDialog.findViewById(R.id.edt_color)
        val edtUptime:EditText = mDialog.findViewById(R.id.edt_uptime)
        val name = edtName.text
        val amount = edtAmount.text.toString()
        val proSize = edtProSize.text
        val color = edtColor.text.toString()
        val upTime = edtUptime.text
//        buider.setPositiveButton(
//            "ok"
//        ) { _, _ -> callBack.dialogOnClick(name, amount.toInt(), proSize, color.toInt(), upTime) }
        buider.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
            callBack.dialogOnClick(name.toString(), amount.toInt(),
                proSize.toString(), color.toInt(), upTime.toString()
            )
        })
        buider.create().show()
    }

    private fun initBelowRcv() {
        rvBelow.adapter = belowAdapter
        rvBelow.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        list.add(ItemBelow(R.drawable.ic_elephant, "elephant"))
        list.add(ItemBelow(R.drawable.ic_horse, "horse"))
        list.add(ItemBelow(R.drawable.ic_dog, "dog"))
        list.add(ItemBelow(R.drawable.ic_cat, "cat"))
        list.add(ItemBelow(R.drawable.ic_bird, "bird"))
    }

    private fun initElephantRcv() {
        listElephant.clear()
        imgShow.colorFilter = null
        Handler().postDelayed({
            imgShow.setImageResource(R.drawable.ic_elephant)

        }, 100)
        rcvAbove.adapter = elephantAdapter
        rcvAbove.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listElephant.add(Elephant(R.drawable.ic_ele_colo, "Gray"))
        listElephant.add(Elephant(R.drawable.ic_ele_green, "Green"))
        listElephant.add(Elephant(R.drawable.ic_ele_yellow, "Yellow"))
    }

    private fun initHorseRcv() {
        listHorse.clear()
        imgShow.setImageResource(R.drawable.horse_imagepng)
        imgShow.colorFilter = null
        rcvAbove.adapter = horseAdapter
        rcvAbove.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listHorse.add(Horse(R.drawable.ic_red, "Red"))
        listHorse.add(Horse(R.drawable.ic_blue, "Blue"))
        listHorse.add(Horse(R.drawable.ic_green, "Green"))
        listHorse.add(Horse(R.drawable.ic_yellow, "Yellow"))
    }

    private fun initCatRcv() {
        listCat.clear()
        imgShow.setImageResource(R.drawable.ic_cat)
        imgShow.colorFilter = null
        rcvAbove.adapter = catAdapter
        rcvAbove.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Red"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Blue"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Green"))
        listCat.add(Cat(R.drawable.ic_cat_yellow, "Yellow"))
    }

    private fun initDogRcv() {
        listDog.clear()
        imgShow.setImageResource(R.drawable.ic_dog)
        imgShow.colorFilter = null


        rcvAbove.adapter = dogAdapter
        rcvAbove.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listDog.add(Dog(R.drawable.ic_dog_black, "Red"))
        listDog.add(Dog(R.drawable.ic_dog_black, "Blue"))
        listDog.add(Dog(R.drawable.ic_dog_black, "Green"))
    }

    private fun initBirdRcv() {
        listBird.clear()
        imgShow.setImageResource(R.drawable.ic_bird)
        imgShow.colorFilter = null
        rcvAbove.adapter = birdAdapter
        rcvAbove.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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

    private var getImg: Int = 0

    override fun onEleItemClick(position: Int) {
        when (position) {
            0 -> {
                getImg = R.drawable.ic_ele_colo
                imgShow.setImageResource(getImg)
            }
            1 -> {
                getImg = R.drawable.ic_ele_green
                imgShow.setImageResource(getImg)
            }
            2 -> {
                getImg = R.drawable.ic_ele_yellow
                imgShow.setImageResource(getImg)
            }

        }
    }

    override fun horseItemClick(position: Int) {
        when (position) {
            0 -> {
                getImg = R.drawable.ic_red
                imgShow.setImageResource(getImg)
            }
            1 -> {getImg = R.drawable.ic_blue
                imgShow.setImageResource(getImg)}

            2 -> {
                getImg = R.drawable.ic_green
                imgShow.setImageResource(getImg)
            }
            3 -> {
                getImg = R.drawable.ic_yellow
                imgShow.setImageResource(getImg)
            }
        }
    }

    override fun dogItemClick(position: Int) {

    }

    override fun catItemClick(position: Int) {

    }

    override fun birdItemClick(position: Int) {

    }

    override fun dialogOnClick(
        name: String,
        amount: Int,
        proSize: String,
        color: Int,
        upTime: String
    ) {
        val uuid: UUID = UUID.randomUUID()
        val randomUUIDString: String = uuid.toString()
        val product = Pro()
        product.id = "PRO:$randomUUIDString"
        product.image = getImg
        product.name = name
        product.amount = amount
        product.proSize = proSize
        product.color = 500
        product.upTime = upTime
        manager.addProduct(realm = realm, product = product)
        Toast.makeText(context, "Add to cart successfully!", Toast.LENGTH_SHORT).show()
    }


}