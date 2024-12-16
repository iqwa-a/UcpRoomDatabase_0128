package com.example.ucp2_pam.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mata Kuliah")
data class matakuliah(
    @PrimaryKey
    val kode: String,
    val nama: String,
    val sks: String,
    val semester: String,
    val jenis: String,
    val dosenpengampu: String
)
