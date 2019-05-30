package com.appbusters.robinpc.constitutionofindia.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink

@Dao
interface BookLinkDao {

    @Query("SELECT * FROM book_links")
    fun getAllBooks(): LiveData<List<BookLink>>

    @Query("SELECT * FROM book_links WHERE id = :id")
    fun getBookById(id: Int): LiveData<BookLink>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBookLinks(vararg bookLinks: BookLink)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBookLink(bookLink: BookLink)

}