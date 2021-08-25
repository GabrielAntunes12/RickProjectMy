package com.example.rickprojectmy.data.repository

import android.util.Log
import com.example.rickprojectmy.data.model.CharacterList
import com.example.rickprojectmy.data.model.Info
import java.lang.Exception

class RickyRepository(private val rickyService: RickyService) {


    suspend fun getRicky() = rickyService.getAllCharacters()
    suspend fun getOneRicky(id : Int) = rickyService.getOneCharacter(id)
    suspend fun getRickyNew(inta : Int) = rickyService.getAllCharactersNew(inta)

}