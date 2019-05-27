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

    private var tagRepository: TagRepository = TagRepository(appDatabase.tagDao())
    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())

    private var allTagsLiveData: LiveData<List<Tag>>
    private var tagsCountLiveData: LiveData<Int>

    init {
        allTagsLiveData = tagRepository.getAllTags()
        tagsCountLiveData = tagRepository.getNumberOfTags()
    }

    fun getAllTags(): LiveData<List<Tag>> {
        return allTagsLiveData
    }

    fun getNumberOfTags(): LiveData<Int> {
        return tagsCountLiveData
    }

    fun insertTags(vararg tags: Tag) {
        tagRepository.insertTags(*tags)
    }
}