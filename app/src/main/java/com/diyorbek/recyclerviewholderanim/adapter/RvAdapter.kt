package com.diyorbek.recyclerviewholderanim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.diyorbek.recyclerviewholderanim.R
import com.diyorbek.recyclerviewholderanim.databinding.ItemLayoutBinding
import com.diyorbek.recyclerviewholderanim.model.Model

class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    var modelList: MutableList<Model> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        context = parent.context
        return RvViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(modelList[position])
        holder.itemView.animation = AnimationUtils.loadAnimation(context, R.anim.anim_1)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    inner class RvViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: Model){
            binding.textView.text = model.name
        }
    }
}