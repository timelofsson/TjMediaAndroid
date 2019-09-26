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
import com.example.myapp.adapter.PoseWithMultiplePictureAdapter
import com.example.myapp.models.PoseWithMultiplePictures

class OtherFragment : Fragment() , PoseWithMultiplePictureAdapter.OnPoseListener {
    private val poses: ArrayList<PoseWithMultiplePictures> = ArrayList()

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
        recyclerView.adapter = PoseWithMultiplePictureAdapter(poses, this.context!!, this, resources)
        recyclerView.itemAnimator = DefaultItemAnimator()

        return rootView
    }

    override fun onPoseClick(position: Int) {
        val intent = Intent(activity, PoseWithMultiplePicturesActivity::class.java)
        intent.putExtra("pose", poses[position])

        startActivity(intent)
    }


    // Adds animals to the empty animals ArrayList
    fun addPoses() {
        poses.add(
            PoseWithMultiplePictures(
                resources.getString(R.string.intimate_pose_title),
                resources.getString(R.string.intimate_pose_text),
                R.mipmap.intimate_pose,
                intArrayOf(R.drawable.intimate, R.drawable.intimate_landscape)
            )
        )

        poses.add(
            PoseWithMultiplePictures(
                resources.getString(R.string.hipster_pose_title),
                resources.getString(R.string.hipster_pose_text),
                R.mipmap.hipster_pose,
                intArrayOf(R.drawable.hipster_pose, R.drawable.hipster_pose_variation, R.drawable.hipster_pose_variation_2)
            )
        )

        poses.add(
            PoseWithMultiplePictures(
                resources.getString(R.string.twirl_pose_title),
                resources.getString(R.string.twirl_pose_text),
                R.mipmap.the_twirl,
                intArrayOf(R.drawable.the_twirl)
            )
        )
    }
}