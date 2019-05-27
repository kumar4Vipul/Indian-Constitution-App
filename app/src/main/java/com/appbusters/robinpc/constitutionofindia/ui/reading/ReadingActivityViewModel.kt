package com.appbusters.robinpc.constitutionofindia.ui.reading

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.data.repository.ReadElementRepository
import com.appbusters.robinpc.constitutionofindia.data.repository.TagRepository
import javax.inject.Inject

class ReadingActivityViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())

    fun markElementAsSaved(elementId: Int) {
        elementsRepository.markElementAsSaved(elementId)
    }

    fun markElementAsUnsaved(elementId: Int) {
        elementsRepository.markElementAsUnsaved(elementId)
    }

    fun isElementSaved(elementId: Int): LiveData<Int> {
        return elementsRepository.isElementSaved(elementId)
    }
}