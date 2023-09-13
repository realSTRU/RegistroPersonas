package com.example.registropersonascompose.ui.person

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registropersonascompose.data.PersonDB
import com.example.registropersonascompose.domain.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val personDB: PersonDB
) : ViewModel() {
    var name : String by mutableStateOf("")
    var ocupationId : Int by mutableStateOf (0)
    var image by mutableStateOf<Uri?> (null)
    var telephone: String by mutableStateOf("")
    var cellphone: String by mutableStateOf("")
    var email: String by mutableStateOf("")
    var fechaNacimiento: String by mutableStateOf("")
    var direccion: String by mutableStateOf("")



    private val _isMessageShown = MutableSharedFlow<Boolean>()
    val isMessageShownFlow = _isMessageShown.asSharedFlow()

    fun setMessageShown() {
        viewModelScope.launch {
            _isMessageShown.emit(true)
        }
    }

    val persons: StateFlow<List<Person>> = personDB.personDao().getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )


    fun SavePerson() {
        viewModelScope.launch {
            val person: Person = Person(
                name = name,
                ocupationId = this@PersonViewModel.ocupationId,
                image = image.toString(),
                cellphone = cellphone,
                telephone = telephone,
                email = email,
                direccion = direccion,
                fechaNacimiento = fechaNacimiento

            )
            personDB.personDao().save(person)
            Clear()
        }
    }
    fun DeletePerson(
        personId : Int
    ) {
        viewModelScope.launch {
            val person = personDB.personDao().find(personId)
            personDB.personDao().delete(person)
            Clear()
        }
    }

    private fun Clear() {
        name = ""
        this.ocupationId = 0
    }
}