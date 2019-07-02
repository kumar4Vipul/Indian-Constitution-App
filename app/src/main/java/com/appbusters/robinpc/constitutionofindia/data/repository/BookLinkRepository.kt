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
        InsertBookLinksTask(bookLinkDao).execute(*bookLinks)
    }

    fun insertBookLink(bookLink: BookLink) {
        InsertBookLinkTask(bookLinkDao).execute(bookLink)
    }

    private class InsertBookLinksTask internal constructor(private val bookLinkDao: BookLinkDao) : AsyncTask<BookLink, Void, Void>() {

        override fun doInBackground(vararg params: BookLink): Void? {
            bookLinkDao.insertBookLinks(*params)
            return null
        }
    }

    private class InsertBookLinkTask internal constructor(private val bookLinkDao: BookLinkDao) : AsyncTask<BookLink, Void, Void>() {

        override fun doInBackground(vararg param: BookLink): Void? {
            bookLinkDao.insertBookLink(param[0])
            return null
        }
    }
}