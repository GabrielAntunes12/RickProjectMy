package com.example.rickprojectmy.data.repository

import com.example.rickprojectmy.data.model.Character
import com.example.rickprojectmy.data.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickyService {

    @GET("character")
    suspend fun getAllCharacters() : CharacterList

    @GET("character/{id}")
    suspend fun getOneCharacter(@Path("id") id: Int): Character

    @GET("character")
    suspend fun getAllCharactersNew(@Query("page") inta: Int) : CharacterList



}