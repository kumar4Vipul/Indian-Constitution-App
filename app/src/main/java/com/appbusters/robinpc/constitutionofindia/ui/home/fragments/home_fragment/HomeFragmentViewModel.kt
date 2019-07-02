package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.data.model.*
import com.appbusters.robinpc.constitutionofindia.data.repository.BookLinkRepository
import com.appbusters.robinpc.constitutionofindia.data.repository.PartRepository
import com.appbusters.robinpc.constitutionofindia.data.repository.ReadElementRepository
import com.appbusters.robinpc.constitutionofindia.data.repository.TagRepository
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.JSON_BOOK_LINKS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.JSON_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.JSON_READ_ELEMENTS
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

@Suppress("unused")
class HomeFragmentViewModel @Inject constructor(
        appDatabase: AppDatabase,
        private val gson: Gson,
        private val inputStream: InputStream
    ) : ViewModel() {

    private var tagRepository: TagRepository = TagRepository(appDatabase.tagDao())
    private var elementsRepository: ReadElementRepository = ReadElementRepository(appDatabase.readElementDao())
    private var partsRepository: PartRepository = PartRepository(appDatabase.partDao())
    private var bookLinkRepository: BookLinkRepository = BookLinkRepository(appDatabase.bookLinkDao())

    private var allTagsLiveData: LiveData<List<Tag>>
    private var tagsCountLiveData: LiveData<Int>

    private var allElementsLiveData: LiveData<List<ReadElement>>
    private var elementsCountLiveData: LiveData<Int>

    private var categoriesList: MutableList<Category> = ArrayList()

    private lateinit var jsonString: String

    private val _categoriesListLiveData = MutableLiveData<MutableList<Category>>()
    val categoriesListLiveData: LiveData<MutableList<Category>>
        get() = _categoriesListLiveData

    init {
        allTagsLiveData = tagRepository.getAllTags()
        tagsCountLiveData = tagRepository.getNumberOfTags()

        allElementsLiveData = elementsRepository.getAllElements()
        elementsCountLiveData = elementsRepository.getNumberOfElements()
    }

    fun getAllBooks(): LiveData<List<BookLink>> {
        return bookLinkRepository.getAllBooks()
    }

    fun getAllParts(): LiveData<List<Part>> {
        return partsRepository.getAllParts()
    }

    fun getAllTags(): LiveData<List<Tag>> {
        return allTagsLiveData
    }

    fun getAllElements(): LiveData<List<ReadElement>> {
        return allElementsLiveData
    }

    private fun insertTags(vararg tags: Tag) {
        tagRepository.insertTags(*tags)
    }

    private fun insertTag(tag: Tag) {
        tagRepository.insertTag(tag)
    }

    private fun insertElements(vararg elements: ReadElement) {
        elementsRepository.insertElements(*elements)
    }

    private fun insertElement(element: ReadElement) {
        elementsRepository.insertElement(element)
    }

    private fun insertBooks(vararg books: BookLink) {
        bookLinkRepository.insertBookLinks(*books)
    }

    private fun insertBook(book: BookLink) {
        bookLinkRepository.insertBookLink(book)
    }

    private fun insertParts(vararg parts: Part) {
        partsRepository.insertParts(*parts)
    }

    private fun insertPart(part: Part) {
        partsRepository.insertPart(part)
    }

    fun inflateCategoriesList() {
        categoriesList.add(Category(R.color.schedules_color, Constants.CATEGORY_SCHEDULES))
        categoriesList.add(Category(R.color.parts_color, Constants.CATEGORY_PARTS))
        categoriesList.add(Category(R.color.amendment_color, Constants.CATEGORY_AMENDMENTS))
        categoriesList.add(Category(R.color.preamble_color, Constants.CATEGORY_PREAMBLE))
        _categoriesListLiveData.postValue(categoriesList)
    }

    fun loadPartsFromJson() {
        try {
            inflatePartsList(getPartsArray())
        }
        catch (e: IOException) {}
    }

    private fun getPartsArray(): JSONArray {
        if(::jsonString.isInitialized) {
            val jsonObject = JSONObject(jsonString)
            return jsonObject.getJSONArray(JSON_PARTS)
        }
        else {
            loadJsonString()
            return getPartsArray()
        }
    }

    fun inflatePartsList(parts: JSONArray) {
        var part: Part
        for(partIndex: Int in 0 until parts.length()) {
            part = gson.fromJson(parts.getJSONObject(partIndex).toString(), Part::class.java)
            insertPart(part)
        }
    }

    fun loadTagsFromJson() {
        try {
            inflateTagsList(getTagsArray())
        }
        catch (e: IOException) {}
    }

    private fun inflateTagsList(tags: JSONArray) {
        var  tagItem: Tag
        for(tagNumber: Int in 0 until tags.length()) {
            tagItem = gson.fromJson(tags.getJSONObject(tagNumber).toString(), Tag::class.java)
            insertTag(tagItem)
        }
    }

    fun getSubmitTagList(tagsList: List<Tag>): List<Tag> {
        val submitTagList: MutableList<Tag> = ArrayList()

        for(tag in tagsList)
            if(!tag.categoryName.equals(Constants.CATEGORY_STATE))
                submitTagList.add(tag)

        return submitTagList
    }

    private fun getTagsArray(): JSONArray {
        if(::jsonString.isInitialized) {
            val jsonObject = JSONObject(jsonString)
            return jsonObject.getJSONArray(Constants.JSON_TAGS)
        }
        else {
            loadJsonString()
            return getTagsArray()
        }
    }

    fun loadBooksFromJson() {
        try {
            inflateBooksList(getBooksArray())
        } catch (e: IOException) {}
    }

    private fun inflateBooksList(books: JSONArray) {
        var  book: BookLink
        for(bookNumber: Int in 0 until books.length()) {
            book = gson.fromJson(books.getJSONObject(bookNumber).toString(), BookLink::class.java)
            insertBook(book)
        }
    }

    fun loadElementsFromJson() {
        try {
            inflateElementsList(getElementsArray())
        }
        catch (e: IOException) {}
    }

    private fun inflateElementsList(elements: JSONArray) {
        var  elementItem: ReadElement
        for(elementNumber: Int in 0 until elements.length()) {
            elementItem = gson.fromJson(elements.getJSONObject(elementNumber).toString(), ReadElement::class.java)
            insertElement(elementItem)
        }
    }

    private fun getBooksArray(): JSONArray {
        if(::jsonString.isInitialized) {
            val jsonObject = JSONObject(jsonString)
            return jsonObject.getJSONArray(JSON_BOOK_LINKS)
        }
        else {
            loadJsonString()
            return getBooksArray()
        }
    }

    private fun getElementsArray(): JSONArray {
        if(::jsonString.isInitialized) {
            val jsonObject = JSONObject(jsonString)
            return jsonObject.getJSONArray(JSON_READ_ELEMENTS)
        }
        else {
            loadJsonString()
            return getElementsArray()
        }
    }

    private fun loadJsonString() {
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        jsonString = String(buffer, Charset.forName(Constants.CHARSET_UTF_8))
    }
}