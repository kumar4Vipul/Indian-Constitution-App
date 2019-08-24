package com.appbusters.robinpc.constitutionofindia.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

@Dao
interface ReadElementDao {

    @Query("SELECT count(id) FROM read_element")
    fun getNumberOfElements(): LiveData<Int>

    @Query("SELECT * FROM read_element")
    fun getAllElements(): LiveData<List<ReadElement>>

    @Query("SELECT * FROM read_element WHERE id IN (:readElementIds)")
    fun findElementsByIds(readElementIds: IntArray): LiveData<List<ReadElement>>

    @Query("SELECT * FROM read_element WHERE id = :elementId")
    fun findElementById(elementId: Int): LiveData<ReadElement>

    @Query("SELECT count(*) FROM read_element WHERE id = :elementId AND is_saved = 1")
    fun checkIfElementIsSaved(elementId: Int): LiveData<Int>

    @Query("SELECT * FROM read_element WHERE id BETWEEN :startId AND :endId")
    fun getElementsInRange(startId: Int, endId: Int): LiveData<List<ReadElement>>

    @Query("SELECT * FROM read_element WHERE id IN(:ids)")
    fun getElementsForIds(ids: List<Int>): LiveData<List<ReadElement>>

    @Query("UPDATE read_element SET is_saved = 1 WHERE id = :elementId")
    fun markElementAsSaved(elementId: Int)

    @Query("UPDATE read_element SET is_saved = 0 WHERE id = :elementId")
    fun markElementAsUnsaved(elementId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElements(vararg readElements: ReadElement)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertElement(readElement: ReadElement)

    @Delete
    fun delete(readElement: ReadElement)

    @Query("SELECT is_saved FROM read_element WHERE id = :elementId")
    fun isElementSaved(elementId: Int): LiveData<Int>

    @Query("SELECT count(*) FROM read_element WHERE category = :categoryName AND is_saved = 1")
    fun getSaveCountForCategory(categoryName: String): LiveData<Int>

    @Query("SELECT * FROM read_element WHERE is_saved = 1")
    fun getSavedElements(): LiveData<List<ReadElement>>

    @Query("SELECT * FROM read_element WHERE category = :categoryName AND is_saved = 1")
    fun getCategorySavedElements(categoryName: String): LiveData<List<ReadElement>>
}