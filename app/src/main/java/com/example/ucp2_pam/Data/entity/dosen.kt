package com.example.ucp2_pam.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Menandai kelas ini sebagai entitas database untuk tabel "dosen"
@Entity(tableName = "dosen")
data class dosen(
    @PrimaryKey // Menandai kolom Nidn sebagai primary key
    val Nidn: String, // Nomor Induk, unik untuk setiap mahasiswa
    val Nama: String, // Nama mahasiswa
    val jenisKelamin: String, // Jenis kelamin mahasiswa
)