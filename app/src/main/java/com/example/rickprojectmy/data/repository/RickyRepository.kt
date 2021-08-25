package com.example.rickprojectmy.data.repository


class RickyRepository(private val rickyService: RickyService) {


    suspend fun getOneRicky(id : Int) = rickyService.getOneCharacter(id)
    suspend fun getRickyNew(inta : Int) = rickyService.getAllCharactersNew(inta)

}