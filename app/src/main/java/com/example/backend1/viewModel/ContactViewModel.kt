package com.example.backend1.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.backend1.model.Contact
import com.example.backend1.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: ContactRepository) : ViewModel() {

    // Use mutable state to hold the contacts
    private val _contacts = mutableStateOf<List<Contact>>(emptyList())
    val contacts: State<List<Contact>> = _contacts

    init {
        // Fetch contacts when the ViewModel is initialized
        getContacts()
    }

    private fun getContacts() {
        viewModelScope.launch {
            _contacts.value = repository.getAllContacts()
        }
    }

    fun insert(contact: Contact) {
        viewModelScope.launch {
            repository.insert(contact)
            getContacts() // Refresh the list after inserting
        }
    }

    fun update(contact: Contact) {
        viewModelScope.launch {
            repository.update(contact)
            getContacts() // Refresh the list after updating
        }
    }

    fun delete(contact: Contact) {
        viewModelScope.launch {
            repository.delete(contact)
            getContacts() // Refresh the list after deleting
        }
    }
}