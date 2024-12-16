package com.example.ucp2_pam.Data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_pam.Data.entity.matakuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MatakuliahDao {
    @Insert
    suspend fun insertMatakuliahDao(
        MatakuliahDao:
    )

    @Query("SELECT * FROM MataKuliah ORDER BY nama ASC")
    fun getAllmatakuliah(): Flow<List<matakuliah>>

    @Query("SELECT * FROM matakuliah WHERE kode = :kode")
    fun getmatakuliah(nim: String): Flow<matakuliah>

    @Delete
    suspend fun deletematakuliah(mahasiswa: matakuliah)

    @Update
    suspend fun updatematakuliah(mahasiswa:matakuliah)
}