package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.adapter.PoseAdapter
import com.example.myapp.models.Pose

class CouplesPoseFragment : Fragment() , PoseAdapter.OnPoseListener {
    private val poses: ArrayList<Pose> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.other_fragment, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.rv_detail_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        if (poses.size <= 0) {
            addPoses()
        }
        recyclerView.adapter = PoseAdapter(poses, this.context!!, this, resources)
        recyclerView.itemAnimator = DefaultItemAnimator()

        return rootView
    }

    override fun onPoseClick(position: Int) {
        val intent = Intent(activity, PoseActivity::class.java)
        intent.putExtra("pose", poses[position])

        startActivity(intent)
    }


    // Adds animals to the empty animals ArrayList
    fun addPoses() {


        poses.add(
            Pose(
                resources.getString(R.string.hipster_pose_title),
                resources.getString(R.string.hipster_pose_text),
                R.mipmap.hipster_pose,
                intArrayOf(R.drawable.hipster_pose, R.drawable.hipster_pose_variation, R.drawable.hipster_pose_variation_2, R.drawable.opened_up)
            )
        )

        poses.add(
            Pose(
                resources.getString(R.string.intimate_pose_title),
                resources.getString(R.string.intimate_pose_text),
                R.mipmap.intimate_pose,
                intArrayOf(R.drawable.intimate, R.drawable.intimate_landscape)
            )
        )

        poses.add(
            Pose(
                resources.getString(R.string.twirl_pose_title),
                resources.getString(R.string.twirl_pose_text),
                R.mipmap.the_twirl,
                intArrayOf(R.drawable.the_twirl)
            )
        )

        poses.add(
            Pose(
                resources.getString(R.string.waling_pose_title),
                resources.getString(R.string.waling_pose_text),
                R.mipmap.walk,
                intArrayOf(R.drawable.the_walk, R.drawable.waling_shot)
            )
        )

        poses.add(Pose(resources.getString(R.string.v_up_title), resources.getString(R.string.v_up_text), R.mipmap.v_up, intArrayOf(R.drawable.v_up)))
        poses.add(Pose("Closed Up", resources.getString(R.string.closed_up_text), R.mipmap.closed_up, intArrayOf(R.drawable.closed_up)))
        poses.add(Pose("Stacked", resources.getString(R.string.stacked), R.mipmap.stacked, intArrayOf(R.drawable.couples_stacked)))
        poses.add(Pose("The Swing",  resources.getString(R.string.the_swing_text), R.mipmap.the_swing, intArrayOf(R.drawable.the_swing)))
        poses.add(Pose("The Carry", resources.getString(R.string.the_carry_text), R.mipmap.the_carry, intArrayOf(R.drawable.carry)))
        poses.add(Pose("Staggered Couple", resources.getString(R.string.the_staggered_couple_text), R.mipmap.staggered, intArrayOf(R.drawable.staggered)))
        poses.add(Pose("Meet in the middle",  resources.getString(R.string.meet_in_middle_text), R.mipmap.meet_in_middle, intArrayOf(R.drawable.meet_in_middle)))
        poses.add(Pose("The Dip", resources.getString(R.string.the_dip_text), R.mipmap.dip, intArrayOf(R.drawable.dip_pose)))
    }
}