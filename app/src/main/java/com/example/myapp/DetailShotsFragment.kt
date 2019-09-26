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

class DetailShotsFragment : Fragment(), PoseAdapter.OnPoseListener{
    private val poses: ArrayList<Pose> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.couple_poses_fragment, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.rv_main_list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        if(poses.size <= 0){
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
        poses.add(Pose(resources.getString(R.string.detail_cufflings_title), resources.getString(R.string.detail_cufflings_text), R.mipmap.cufflings, intArrayOf(R.drawable.cufflings)))
        poses.add(Pose(resources.getString(R.string.detail_venue_title), resources.getString(R.string.detail_venue_text), R.mipmap.venue, intArrayOf(R.drawable.venue1, R.drawable.venue2)))
        poses.add(Pose(resources.getString(R.string.detail_bouquet_title), resources.getString(R.string.detail_bouquet_text), R.mipmap.bouquet, intArrayOf(R.mipmap.bouquet_foreground)))
        poses.add(Pose(resources.getString(R.string.detail_shoes_title), resources.getString(R.string.detail_shoes_text), R.mipmap.shoes, intArrayOf(R.mipmap.shoes_foreground)))
        poses.add(Pose(resources.getString(R.string.detail_veil_title), resources.getString(R.string.detail_veil_text), R.mipmap.veil, intArrayOf(R.mipmap.veil_foreground)))
        poses.add(Pose(resources.getString(R.string.detail_rings_title), resources.getString(R.string.detail_rings_text), R.mipmap.rings, intArrayOf(R.mipmap.rings_foreground)))
        poses.add(Pose(resources.getString(R.string.detail_invitation_title), resources.getString(R.string.detail_invitation_text), R.mipmap.program, intArrayOf(R.drawable.weddingprogram)))
        poses.add(Pose(resources.getString(R.string.detail_cake_title), resources.getString(R.string.detail_cake_text), R.mipmap.cake, intArrayOf(R.drawable.cake)))
    }
}
