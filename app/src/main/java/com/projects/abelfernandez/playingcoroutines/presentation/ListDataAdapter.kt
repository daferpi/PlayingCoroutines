package com.projects.abelfernandez.playingcoroutines.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.projects.abelfernandez.playingcoroutines.domain.entity.Item


class ListDataAdapter(private val itemsList:List<Item>): RecyclerView.Adapter<ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val textView = TextView(parent.context)

        textView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        return ItemViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        viewHolder.textView.text = itemsList[position].name
    }

}
class ItemViewHolder(val textView:TextView): RecyclerView.ViewHolder(textView)