package com.appbusters.robinpc.constitutionofindia.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.appbusters.robinpc.constitutionofindia.data.model.Tag

@Dao
interface TagDao {

    @Query("SELECT * FROM tag")
    fun getAllTags(): LiveData<List<Tag>>

    @Query("SELECT count(title) FROM tag")
    fun getNumberOfTags(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTags(vararg tags: Tag)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTag(tag: Tag)

    @Delete
    fun deleteTag(tag: Tag)
}