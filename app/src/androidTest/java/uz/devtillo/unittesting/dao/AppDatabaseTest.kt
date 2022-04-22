package uz.devtillo.unittesting.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import uz.devtillo.unittesting.entity.Contact

class AppDatabaseTest {

    lateinit var appDatabase: AppDatabase
    lateinit var contactDao: ContactDao

    @Before
    fun setUp() {
        val applicationContext = ApplicationProvider.getApplicationContext<Context>()
        appDatabase =
            Room.inMemoryDatabaseBuilder(applicationContext, AppDatabase::class.java).build()
        contactDao = appDatabase.contactDao()
    }

    @Test
    fun insertMethods() {
        var contact = Contact(name = "Rahmatillo", number = "+998998935446")
        contactDao.addContact(contact)
        assertTrue(contactDao.getContacts().contains(contact))
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }
}