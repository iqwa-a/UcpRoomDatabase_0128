package com.example.ucp2_pam.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MataKuliah")
data class Matakuliah(
    @PrimaryKey
    val kode: String,
    val nama: String,
    val sks: String,
    val semester: String,
    val jenis: String,
    val dosenpengampu: String
)
