package com.example.ucp2_pam.repository

import com.example.ucp2_pam.Data.entity.Matakuliah
import kotlinx.coroutines.flow.Flow

interface RepositoryMatakuliah {
    suspend fun insertMtk(matakuliah: Matakuliah)
    //getAllMatakuliah
    fun getAllMtk(): Flow<List<Matakuliah>>
    //getMatakuliah
    fun getMatakuliah(kode: String): Flow<Matakuliah>
    //deleteMatakuliah
    suspend fun deleteMtk(matakuliah: Matakuliah)
    //updateMatakuliah
    suspend fun updateMtk(matakuliah: Matakuliah)
}
