package com.example.ucp2_pam.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_pam.Data.entity.Matakuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MatakuliahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatakuliah(matakuliah: Matakuliah): Long

    @Query("SELECT * FROM MataKuliah ORDER BY nama ASC")
    fun getAllmatakuliah(): Flow<List<Matakuliah>>

    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getmatakuliah(nim: String): Flow<Matakuliah>

    @Delete
    suspend fun deletematakuliah(mahasiswa: Matakuliah)

    @Update
    suspend fun updatematakuliah(mahasiswa:Matakuliah)
}