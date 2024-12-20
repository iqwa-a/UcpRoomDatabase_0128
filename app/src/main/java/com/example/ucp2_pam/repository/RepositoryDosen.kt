package com.example.ucp2_pam.repository

import com.example.ucp2_pam.Data.entity.Dosen
import kotlinx.coroutines.flow.Flow

interface RepositoryDosen {suspend fun insertDosen(dosen: Dosen)
    //getAllDosen
    fun getAllDsn(): Flow<List<Dosen>>
    //getDosen
    fun getDosen(nidn: String): Flow<Dosen>
}