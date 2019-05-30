package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.featured_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink
import com.appbusters.robinpc.constitutionofindia.data.repository.BookLinkRepository
import javax.inject.Inject

class FeaturedFragmentViewModel @Inject constructor(appDatabase: AppDatabase): ViewModel() {

    private var bookLinkRepository: BookLinkRepository = BookLinkRepository(appDatabase.bookLinkDao())

    fun getBookById(id: Int): LiveData<BookLink> {
        return bookLinkRepository.getBookById(id)
    }
}