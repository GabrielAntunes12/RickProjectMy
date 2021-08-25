package com.example.rickprojectmy.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickprojectmy.R
import com.example.rickprojectmy.data.ClickListener
import com.example.rickprojectmy.ui.adapter.ListAdapterRick
import com.example.rickprojectmy.ui.viewmodel.RickyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading_bar.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ClickListener{
    private val viewModel by viewModel<RickyViewModel>()
    private val adapter: ListAdapterRick by inject()
    private var count = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setScroll()
        setUpRecycler()
        setList()
        setupObservers()


    }

    private fun setScroll() {
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if(!recycler.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                    if(count<34) {
                        viewModel.start(count)
                        count++
                        loading_bar.visibility = View.VISIBLE
                    }
                    Log.e("aShura", "OASDASDSAD")
                }
            }
        })
    }


    private fun setupObservers() {
        viewModel.test1.observe(this, {
            adapter.apply {
                addCharList(it.results)
                loading_bar.visibility = View.GONE

            }
        })


    }

    private fun setList() {
        viewModel.start(1)
    }



    private fun setUpRecycler() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        adapter.attachListener(this)

    }

    override fun onClick(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("idChar", id)
        startActivity(intent)
    }

    override fun onClick(character: Character) {
    }





}