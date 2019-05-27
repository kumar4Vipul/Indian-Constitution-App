package com.appbusters.robinpc.constitutionofindia.ui.intermediate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.data.repository.PartRepository
import javax.inject.Inject

class MiddleActivityViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var partRepository = PartRepository(appDatabase.partDao())

    fun getAllParts(): LiveData<List<Part>> {
        return partRepository.getAllParts()
    }
}