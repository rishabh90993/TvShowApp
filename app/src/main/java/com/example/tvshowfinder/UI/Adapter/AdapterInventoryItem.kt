package com.example.tvshowfinder.UI.Adapter;

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvshowfinder.Data.models.Results
import com.example.tvshowfinder.R
import com.example.tvshowfinder.databinding.ItemTvshowBinding


class AdapterTvShowItem(val context: Context, val onItemClick: (item: Results) -> Unit) :
    RecyclerView.Adapter<AdapterTvShowItem.ViewHolder>() {

    private val items = mutableListOf<Results>()

    fun clearAndAddItems(addItems: List<Results>) {
        this.items.clear()
        this.items.addAll(addItems)
        notifyDataSetChanged()
    }

    fun addItems(addItems: List<Results>) {
        var start = items.size - 1
        this.items.addAll(addItems)
        notifyItemRangeInserted(start,addItems.size)
//        sort(sortType)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTvshowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        Glide.with(context)
            .load(item.getImageUrl() ?:"")
            .placeholder(R.drawable.no_image)
            .into(holder.itemBinding.imgTvShow)

        holder.itemBinding.titleTvShow.text = item.title

        holder.itemBinding.executePendingBindings()
    }

    inner class ViewHolder(val itemBinding: ItemTvshowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemBinding.root.setOnClickListener {
                onItemClick(items[adapterPosition])
            }
        }
    }
}