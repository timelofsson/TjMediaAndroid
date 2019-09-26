package com.example.myapp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){

    val otherFragment = DetailShotsFragment()
    val galleryFragment = GalleryActivity()
    val couplesFragment = CouplesPoseFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the toolbar view inside the activity layout
        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        toolbar.setTitleTextColor(resources.getColor(R.color.colorAccent, this.theme))
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar)

        supportActionBar?.setIcon(R.mipmap.tjmedia)

        //Add basic poses
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, couplesFragment, couplesFragment::class.java.simpleName)
            .commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val activeFragment: Fragment
                when (item.itemId) {
                    R.id.action_couple ->
                        activeFragment = couplesFragment
                    R.id.action_detail ->
                        activeFragment = otherFragment
                    R.id.action_gallery -> {
                       activeFragment = galleryFragment
                    }
                    else -> return true
                }
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_fragment, activeFragment, activeFragment::class.java.simpleName)
                    .commit()
                return true
            }
        })
    }
}
