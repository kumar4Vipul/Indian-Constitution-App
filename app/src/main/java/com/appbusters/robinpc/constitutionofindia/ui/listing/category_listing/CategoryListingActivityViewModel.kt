package com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.repository.ReadElementRepository
import javax.inject.Inject

class CategoryListingActivityViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())

    fun getElementsInRange(startId: Int, endId: Int): LiveData<List<ReadElement>> {
        return elementsRepository.getElementsInRange(startId, endId)
    }

    fun getElementsForIds(ids: List<Int>): LiveData<List<ReadElement>> {
        return elementsRepository.getElementsForIds(ids)
    }

}