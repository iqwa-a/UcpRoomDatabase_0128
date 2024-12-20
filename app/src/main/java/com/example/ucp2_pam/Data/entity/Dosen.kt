package com.example.ucp2_pam.Data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Menandai kelas ini sebagai entitas database untuk tabel "dosen"
@Entity(tableName = "dosen")
data class Dosen(
    @PrimaryKey // Menandai kolom Nidn sebagai primary key
    val nidn: String, // Nomor Induk, unik untuk setiap mahasiswa
    val nama: String, // Nama mahasiswa
    val jeniskelamin: String, // Jenis kelamin mahasiswa
)