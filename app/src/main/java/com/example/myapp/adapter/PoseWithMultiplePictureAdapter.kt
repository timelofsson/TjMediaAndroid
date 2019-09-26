package com.example.myapp.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.models.PoseWithMultiplePictures
import com.example.myapp.service.BitMapService
import kotlinx.android.synthetic.main.pose_list_item.view.*




class PoseWithMultiplePictureAdapter(val items : ArrayList<PoseWithMultiplePictures>, val context: Context, val mOnPoseListener: OnPoseListener, val resources : Resources)
    : RecyclerView.Adapter<PoseWithMultiplePictureAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pose_list_item, parent, false), mOnPoseListener)
    }

    override fun getItemCount(): Int {
       return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvText.text = items[position].title
        holder.tvPictureUrl.setImageBitmap(BitMapService.drawableToBitmap(resources.getDrawable(items[position].image, context.theme)))
    }

    inner class ViewHolder(itemView: View, internal var mOnPoseListener: OnPoseListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvText = itemView.tv_pose_type!!
        val tvPictureUrl = itemView.iv_pose_type!!

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            mOnPoseListener.onPoseClick(adapterPosition)
        }
    }

    interface OnPoseListener {
        fun onPoseClick(position: Int)
    }
}