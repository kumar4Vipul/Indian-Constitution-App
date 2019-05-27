package com.appbusters.robinpc.constitutionofindia.data.repository

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

class ReadElementRepository(private val elementsDao: ReadElementDao) {

    private val elementsListLiveData: LiveData<List<ReadElement>> = elementsDao.getAllElements()
    private val elementsCountLiveData: LiveData<Int> = elementsDao.getNumberOfElements()

    fun getAllElements(): LiveData<List<ReadElement>> {
        return elementsListLiveData
    }

    fun getNumberOfElements(): LiveData<Int> {
        return elementsCountLiveData
    }

    fun insertElements(vararg tags: ReadElement) {
        InsertTagsTask(elementsDao).execute(*tags)
    }

    private class InsertTagsTask internal constructor(private val elementsDao: ReadElementDao) : AsyncTask<ReadElement, Void, Void>() {

        override fun doInBackground(vararg params: ReadElement): Void? {
            Log.e("tag", "inserting element")
            elementsDao.insertElements(*params)
            return null
        }
    }
}
