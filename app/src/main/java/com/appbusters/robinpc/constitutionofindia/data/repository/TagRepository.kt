package com.appbusters.robinpc.constitutionofindia.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.appbusters.robinpc.constitutionofindia.data.dao.TagDao
import com.appbusters.robinpc.constitutionofindia.data.model.Tag

class TagRepository(private val tagsDao: TagDao) {

    private val tagListLiveData: LiveData<List<Tag>> = tagsDao.getAllTags()
    private val tagsCountLiveData: LiveData<Int> = tagsDao.getNumberOfTags()

    fun getAllTags(): LiveData<List<Tag>> {
        return tagListLiveData
    }

    fun getNumberOfTags(): LiveData<Int> {
        return tagsCountLiveData
    }

    fun insertTags(vararg tags: Tag) {
        InsertTagsTask(tagsDao).execute(*tags)
    }

    private class InsertTagsTask internal constructor(private val tagsDao: TagDao) : AsyncTask<Tag, Void, Void>() {

        override fun doInBackground(vararg params: Tag): Void? {
            tagsDao.insertTags(*params)
            return null
        }
    }
}