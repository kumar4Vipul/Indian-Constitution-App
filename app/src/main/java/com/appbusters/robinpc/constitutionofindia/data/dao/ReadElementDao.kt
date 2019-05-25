package com.appbusters.robinpc.constitutionofindia.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

@Dao
interface ReadElementDao {

    @Query("SELECT * FROM read_element")
    fun getAllElements(): List<ReadElement>

    @Query("SELECT * FROM read_element WHERE id IN (:readElementIds)")
    fun findElementsByIds(readElementIds: IntArray): List<ReadElement>

    @Query("SELECT * FROM read_element WHERE id = :elementId")
    fun findElementById(elementId: Int): ReadElement

    @Query("SELECT count(*) FROM read_element WHERE id = :elementId AND is_saved = 1")
    fun checkIfElementIsSaved(elementId: Int): Int

    @Query("UPDATE read_element SET is_saved = 1 WHERE id = :elementId")
    fun markElementAsSaved(elementId: Int)

    @Query("UPDATE read_element SET is_saved = 0 WHERE id = :elementId")
    fun markElementAsUnsaved(elementId: Int)

    @Insert
    fun insertElements(vararg readElements: ReadElement)

    @Insert
    fun insertElement(readElement: ReadElement)

    @Delete
    fun delete(readElement: ReadElement)
}