package com.example.backend1.repository

import com.example.backend1.model.Contact
import com.example.backend1.room.ContactDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(private val contactDao: ContactDao) {
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    suspend fun update(contact: Contact) {
        contactDao.update(contact)
    }

    suspend fun delete(contact: Contact) {
        contactDao.delete(contact)
    }

    suspend fun getAllContacts(): List<Contact> {
        return contactDao.getAllContacts()
    }
}