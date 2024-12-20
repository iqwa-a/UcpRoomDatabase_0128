package com.example.ucp2_pam.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_pam.Data.entity.Dosen
import kotlinx.coroutines.flow.Flow

@Dao
interface DosenDao {
    @Insert
    suspend fun insertdosen(
        dosen: Dosen
    )

    @Query("SELECT * FROM dosen ORDER BY nama ASC")
    fun getAlldosen(): Flow<List<Dosen>>

    @Query("SELECT * FROM dosen WHERE Nidn = :nim")
    fun getdosen(nim: String): Flow<Dosen>

    @Delete
    suspend fun deletedosen(dosen: Dosen)

    @Update
    suspend fun updatedosen(dosen: Dosen)
}