package uz.devtillo.unittesting.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.devtillo.unittesting.entity.Contact

@Dao
interface ContactDao {

    @Insert
    fun addContact(contact: Contact)

    @Query("select *from contact")
    fun getContacts(): List<Contact>

    @Query("select *from contact where name =:name and number=:number")
    fun getContact(name: String, number: String): Contact

}