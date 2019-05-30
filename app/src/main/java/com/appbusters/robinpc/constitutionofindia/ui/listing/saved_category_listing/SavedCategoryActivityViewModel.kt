package com.appbusters.robinpc.constitutionofindia.ui.listing.saved_category_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.repository.ReadElementRepository
import javax.inject.Inject

class SavedCategoryActivityViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())

    fun getCategorySavedElements(categoryName: String): LiveData<List<ReadElement>> {
        return elementsRepository.getCategorySavedElements(categoryName)
    }
}