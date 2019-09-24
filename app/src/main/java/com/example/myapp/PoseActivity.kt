package com.example.myapp

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.models.Pose
import com.example.myapp.service.BitMapService
import kotlinx.android.synthetic.main.pose_main.*
import kotlinx.android.synthetic.main.pose_main.view.*


class PoseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pose_main)

        // Find the toolbar view inside the activity layout
        val toolbar = findViewById<View>(R.id.my_toolbar) as androidx.appcompat.widget.Toolbar
        toolbar.setTitleTextColor(resources.getColor(R.color.colorAccent, this.theme))
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pose = intent.getParcelableExtra<Pose>("pose")
        if(pose != null){

            supportActionBar?.title = pose.title
            pose_fragment.text.text = pose.message
            pose_fragment.imageView.setImageBitmap(BitMapService.drawableToBitmap(resources.getDrawable(pose.imageHighRes, this.theme)))
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
}