package com.example.kudonavdrawerdemo

import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kudonavdrawerdemo.fragment.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var navigationPosition: Int = 0
    lateinit var listgFragment: ListgFragment
    lateinit var designFragment: DesignFragment
    lateinit var cartFragment: CartFragment
    lateinit var homeFragment: HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        nav_view.setNavigationItemSelectedListener(this)
        setSupportActionBar(toolbar)
//        homeFragment = HomeFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment)
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        navigationPosition = R.id.nav_hone
        navigateToFragment(HomeFragment.newInstance())
        nav_view.setCheckedItem(navigationPosition)

//        var menuIcon = resources.getDrawable(R.drawable.menu)
//        menuIcon.colorFilter(resources.getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP)
        nav_icon.setOnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        supportActionBar?.setTitle(null)

    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_hone -> {
//                homeFragment =
//                    HomeFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                navigationPosition = R.id.nav_hone
                navigateToFragment(HomeFragment.newInstance())
                supportActionBar?.show()
            }
            R.id.nav_list -> {
                navigationPosition = R.id.nav_list
                navigateToFragment(ListgFragment.newInstance())
                supportActionBar?.show()
            }
            R.id.nav_design -> {
                navigationPosition = R.id.nav_design
                navigateToFragment(DesignFragment.newInstance())
                supportActionBar?.hide()
//                designFragment =
//                    DesignFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, designFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

            }
            R.id.nav_cart -> {
                navigationPosition = R.id.nav_cart
                navigateToFragment(CartFragment.newInstance())
                supportActionBar?.show()
            }
            R.id.nav_notification -> {
                navigationPosition = R.id.nav_notification
                navigateToFragment(NotifiFragment.newInstance())
                supportActionBar?.show()
            }
            R.id.nav_setting -> {
                navigationPosition = R.id.nav_setting
                navigateToFragment(ChangePassFragment.newInstance())
                supportActionBar?.show()
            }
            R.id.nav_faq -> {
                navigationPosition = R.id.nav_faq
                navigateToFragment(FaqFragment.newInstance())
                supportActionBar?.show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun navigateToFragment(fragmentToNavigate: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragmentToNavigate)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
            return
        }

        if (navigationPosition == R.id.nav_hone) {
            finish()
        } else {
            //Navigate to Inbox Fragment
            navigationPosition = R.id.nav_hone
            navigateToFragment(HomeFragment.newInstance())
            nav_view.setCheckedItem(navigationPosition)
        }
        supportActionBar?.show()
    }
}