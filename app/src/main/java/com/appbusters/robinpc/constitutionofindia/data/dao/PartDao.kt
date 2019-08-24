package com.appbusters.robinpc.constitutionofindia.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appbusters.robinpc.constitutionofindia.data.model.Part

@Dao
interface PartDao {

    @Query("SELECT * FROM part")
    fun getAllParts(): LiveData<List<Part>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParts(vararg parts: Part)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPart(part: Part)
}