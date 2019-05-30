package com.appbusters.robinpc.constitutionofindia.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.appbusters.robinpc.constitutionofindia.data.dao.BookLinkDao
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink

class BookLinkRepository(private val bookLinkDao: BookLinkDao) {

    fun getAllBooks(): LiveData<List<BookLink>> {
        return bookLinkDao.getAllBooks()
    }

    fun getBookById(id: Int): LiveData<BookLink> {
        return bookLinkDao.getBookById(id)
    }

    fun insertBookLinks(vararg bookLinks: BookLink) {
        InsertPartsTask(bookLinkDao).execute(*bookLinks)
    }

    private class InsertPartsTask internal constructor(private val bookLinkDao: BookLinkDao) : AsyncTask<BookLink, Void, Void>() {

        override fun doInBackground(vararg params: BookLink): Void? {
            bookLinkDao.insertBookLinks(*params)
            return null
        }
    }
}