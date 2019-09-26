package com.example.myapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.models.PoseWithMultiplePictures
import com.example.myapp.service.BitMapService
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pose_main.pose_fragment
import kotlinx.android.synthetic.main.pose_main.view.text
import kotlinx.android.synthetic.main.pose_multiple_picture_main.*


class PoseWithMultiplePicturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pose_multiple_picture_main)

        // Find the toolbar view inside the activity layout
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.colorAccent, this.theme))
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pose = intent.getParcelableExtra<PoseWithMultiplePictures>("pose")
        if(pose != null){

            supportActionBar?.title = pose.title
            addAllHighResImageViews(pose.imageHighRes)
            pose_fragment.text.text = pose.message
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addAllHighResImageViews(images : IntArray?){
        images?.forEach {
            //ImageView Setup
            val imageView = ImageView(this)

            //setting image resource
            imageView.setImageBitmap(BitMapService.drawableToBitmap(resources.getDrawable(it, this.theme)))

            imageView.layoutParams.apply {
                RecyclerView.LayoutParams.MATCH_PARENT
                RecyclerView.LayoutParams.WRAP_CONTENT
            }

            //adding view to layout
            pose_fragment.addView(imageView)
        }

    }
}