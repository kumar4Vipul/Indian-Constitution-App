package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.repository.ReadElementRepository
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import javax.inject.Inject

class BookmarkFragmentViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())

    fun getSavedSchedulesCount(): LiveData<Int> {
        return elementsRepository.getSavedCountForCategory(CATEGORY_SCHEDULES)
    }

    fun getSavedAmendmentsCount(): LiveData<Int> {
        return elementsRepository.getSavedCountForCategory(CATEGORY_AMENDMENTS)
    }

    fun getSavedArticlesCount(): LiveData<Int> {
        return elementsRepository.getSavedCountForCategory(CATEGORY_PARTS)
    }

    fun getSavedPreambleCount(): LiveData<Int> {
        return elementsRepository.getSavedCountForCategory(CATEGORY_PREAMBLE)
    }

    fun getSavedElements(): LiveData<List<ReadElement>> {
        return elementsRepository.getSavedElements()
    }
}