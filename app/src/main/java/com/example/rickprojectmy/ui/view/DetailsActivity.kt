package com.example.rickprojectmy.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.rickprojectmy.R
import com.example.rickprojectmy.data.model.Character
import com.example.rickprojectmy.ui.adapter.ListAdapterRick
import com.example.rickprojectmy.ui.viewmodel.DetailsViewModel
import com.example.rickprojectmy.ui.viewmodel.RickyViewModel
import com.example.rickprojectmy.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.loading_bar.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {
    private val sPreferences : SecurityPreferences by inject()
    private val viewModel by viewModel<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setupScreen()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.char.observe(this,{
            setupDetails(it)
        })
}

    private fun setupDetails(char : Character){

        Glide.with(this).load(char.image).circleCrop().into(image_info)
        results_species.text = char.species
        results_status.text = char.status
        results_gender.text = char.gender
        name_info.text = char.name

        sPreferences.store("nameOne", char.name)
        Log.e("TESTEPREFERENCE","${sPreferences.get("nameOne", char.name)}")
        loading_bar.visibility = View.GONE
}


    private fun setupScreen() {
            loading_bar.visibility = View.VISIBLE
            val idVerify = intent.extras
        if (idVerify != null) {
            viewModel.getOne(idVerify.getInt("idChar"))
        }


    }
}