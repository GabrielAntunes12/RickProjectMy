package com.example.rickprojectmy.ui.adapter.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickprojectmy.data.ClickListener
import com.example.rickprojectmy.data.model.Character
import kotlinx.android.synthetic.main.character_item.view.*

class ListViewHolder (itemView : View, var context : Context, private val listener : ClickListener) : RecyclerView.ViewHolder(itemView){
    fun bind(char : Character){
        itemView.name_character.text = char.name
        itemView.status_character.text = char.status
        Glide.with(context).load(char.image).circleCrop().into(itemView.image_character)
        itemView.relative_layout_click.setOnClickListener { listener.onClick(char.id) }

    }
}