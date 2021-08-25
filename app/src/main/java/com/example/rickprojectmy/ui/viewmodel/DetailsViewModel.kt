package com.example.rickprojectmy.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.rickprojectmy.data.model.Character
import com.example.rickprojectmy.data.model.CharacterList
import com.example.rickprojectmy.data.repository.RickyRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class DetailsViewModel (private val repository : RickyRepository) : ViewModel() {

    var char : LiveData<Character> = MutableLiveData()

    fun getOne(id : Int){
        try {
            char = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO){
                emit(repository.getOneRicky(id))
                Log.e("ViewModel", "start: testado foi com resultado", )
            }

            Log.e("ViewModel", "start: testado foi", )

        }catch (e: Exception){
            Log.e("ViewModel", "start: testado erro", )
            Log.e("ViewModel", "start: testado erro ${e.message}", )
        }
    }
}