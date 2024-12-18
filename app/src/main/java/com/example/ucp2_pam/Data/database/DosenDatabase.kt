package com.example.ucp2_pam.Data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ucp2_pam.Data.entity.matakuliah

// Mendefinisikan database Room dengan entitas mahasiswa
@Database(entities = [matakuliah::class], version = 1, exportSchema = false)
abstract class DosenDatabase : RoomDatabase() {