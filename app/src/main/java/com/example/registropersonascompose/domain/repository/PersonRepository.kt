package com.example.registropersonascompose.domain.repository

import com.example.registropersonascompose.data.PersonDB
import com.example.registropersonascompose.domain.model.Person
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personDB: PersonDB
) {
    suspend fun  SavePerson(person: Person) = personDB.personDao().save(person)
    fun getAll() = personDB.personDao().getAll()
}