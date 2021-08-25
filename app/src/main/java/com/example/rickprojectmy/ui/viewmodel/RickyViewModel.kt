package com.example.rickprojectmy.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.rickprojectmy.data.model.Character
import com.example.rickprojectmy.data.model.CharacterList
import com.example.rickprojectmy.data.repository.RickyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.Math.random

class RickyViewModel(private val repository : RickyRepository) : ViewModel(){

    var test1 : MutableLiveData<CharacterList> = MutableLiveData()




    fun start(page:Int){
        try {

            viewModelScope.launch (Dispatchers.IO){


                test1.postValue(repository.getRickyNew(page))

            }
        }catch (e:Exception){
            Log.e("ViewModeladsdasdas", "start: testado erro ${e.message}", )
        }
    }



}