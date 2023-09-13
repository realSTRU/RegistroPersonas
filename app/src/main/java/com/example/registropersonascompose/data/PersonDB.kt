package com.example.registropersonascompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registropersonascompose.data.local.dao.OcupationDao
import com.example.registropersonascompose.data.local.dao.PersonDao
import com.example.registropersonascompose.domain.model.Ocupation
import com.example.registropersonascompose.domain.model.Person

@Database(
    entities = [Person::class, Ocupation::class],
    version = 3
)
abstract class PersonDB : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun occupationDao(): OcupationDao
}
