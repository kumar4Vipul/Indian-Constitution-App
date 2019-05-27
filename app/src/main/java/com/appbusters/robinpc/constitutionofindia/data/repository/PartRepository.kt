package com.appbusters.robinpc.constitutionofindia.data.repository

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.appbusters.robinpc.constitutionofindia.data.dao.PartDao
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

class PartRepository(private val partDao: PartDao) {

    fun getAllParts(): LiveData<List<Part>> {
        return partDao.getAllParts()
    }

    fun insertParts(vararg parts: Part) {
        InsertPartsTask(partDao).execute(*parts)
    }

    private class InsertPartsTask internal constructor(private val partsDao: PartDao) : AsyncTask<Part, Void, Void>() {

        override fun doInBackground(vararg params: Part): Void? {
            partsDao.insertParts(*params)
            return null
        }
    }
}