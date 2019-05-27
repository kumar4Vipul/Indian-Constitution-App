package com.appbusters.robinpc.constitutionofindia.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

class ReadElementRepository(private val elementsDao: ReadElementDao) {

    fun getAllElements(): LiveData<List<ReadElement>> {
        return elementsDao.getAllElements()
    }

    fun getNumberOfElements(): LiveData<Int> {
        return elementsDao.getNumberOfElements()
    }

    fun insertElements(vararg tags: ReadElement) {
        InsertElementsTask(elementsDao).execute(*tags)
    }

    fun getElementsInRange(startId: Int, endId: Int): LiveData<List<ReadElement>> {
        return elementsDao.getElementsInRange(startId, endId)
    }

    fun getElementsForIds(ids: List<Int>): LiveData<List<ReadElement>> {
        return elementsDao.getElementsForIds(ids)
    }

    fun markElementAsSaved(elementId: Int) {
        SaveStatusTask(elementsDao).execute(elementId)
    }

    fun markElementAsUnsaved(elementId: Int) {
        UnsaveStatusTask(elementsDao).execute(elementId)
    }

    fun isElementSaved(elementId: Int): LiveData<Int> {
        return elementsDao.isElementSaved(elementId)
    }

    private class SaveStatusTask internal constructor(private val elementsDao: ReadElementDao)
        : AsyncTask<Int, Void, Void>() {

        override fun doInBackground(vararg params: Int?): Void? {
            params[0]?.let { elementsDao.markElementAsSaved(it) }
            return null
        }
    }

    private class UnsaveStatusTask internal constructor(private val elementsDao: ReadElementDao)
        : AsyncTask<Int, Void, Void>() {

        override fun doInBackground(vararg params: Int?): Void? {
            params[0]?.let { elementsDao.markElementAsUnsaved(it) }
            return null
        }
    }

    private class InsertElementsTask internal constructor(private val elementsDao: ReadElementDao)
        : AsyncTask<ReadElement, Void, Void>() {

        override fun doInBackground(vararg params: ReadElement): Void? {
            elementsDao.insertElements(*params)
            return null
        }
    }
}
