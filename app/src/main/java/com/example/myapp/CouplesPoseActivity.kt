package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.adapter.PoseAdapter
import com.example.myapp.models.Pose
import kotlinx.android.synthetic.main.activity_main.*




class CouplesPoseActivity : AppCompatActivity(), PoseAdapter.OnPoseListener{
    private val poses: ArrayList<Pose> = ArrayList()

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

        addPoses()

        // Creates a vertical Layout Manager
        rv_main_list.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
        rv_main_list.adapter = PoseAdapter(poses, this, this, resources)
    }

    override fun onPoseClick(position: Int) {
        val intent = Intent(this, PoseActivity::class.java)
        intent.putExtra("pose", poses[position])

        startActivity(intent)
    }


    // Adds animals to the empty animals ArrayList
    fun addPoses() {
        poses.add(Pose(resources.getString(R.string.v_up_title), resources.getString(R.string.v_up_text), R.mipmap.v_up, R.drawable.v_up))
        poses.add(Pose("Opened Up", resources.getString(R.string.opened_up_text), R.mipmap.opened_up, R.drawable.opened_up))
        poses.add(Pose("Closed Up", resources.getString(R.string.closed_up_text), R.mipmap.closed_up, R.drawable.closed_up))
        poses.add(Pose("Stacked", resources.getString(R.string.stacked), R.mipmap.stacked, R.drawable.couples_stacked))
        poses.add(Pose("The Swing",  resources.getString(R.string.the_swing_text), R.mipmap.the_swing, R.drawable.the_swing))
        poses.add(Pose("The Carry", resources.getString(R.string.the_carry_text), R.mipmap.the_carry, R.drawable.carry))
        poses.add(Pose("Staggered Couple", resources.getString(R.string.the_staggered_couple_text), R.mipmap.staggered, R.drawable.staggered))
        poses.add(Pose("Meet in the middle",  resources.getString(R.string.meet_in_middle_text), R.mipmap.meet_in_middle, R.drawable.meet_in_middle))
        poses.add(Pose("The Walk", resources.getString(R.string.the_walk_text), R.mipmap.walk, R.drawable.the_walk))
        poses.add(Pose("The Dip", resources.getString(R.string.the_dip_text), R.mipmap.dip, R.drawable.dip_pose))

    }
}
