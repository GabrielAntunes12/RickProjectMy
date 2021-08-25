package com.example.rickprojectmy.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickprojectmy.R
import com.example.rickprojectmy.data.ClickListener
import com.example.rickprojectmy.data.model.Character
import com.example.rickprojectmy.ui.adapter.viewholder.ListViewHolder

class ListAdapterRick(var context : Context) : RecyclerView.Adapter<ListViewHolder>() {
    private var mCharList: MutableList<Character> = arrayListOf()
    private lateinit var mListener : ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ListViewHolder(item,context, mListener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mCharList[position])
    }

    override fun getItemCount(): Int {
        return mCharList.size
    }

    fun updateCharList(list: MutableList<Character>){
        mCharList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: ClickListener){
        mListener = listener
    }

    fun addCharList(addList : List<Character>){
        mCharList.addAll(addList)
        notifyDataSetChanged()
    }


}