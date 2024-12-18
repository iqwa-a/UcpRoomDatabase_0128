package com.example.ucp2_pam.Data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2_pam.Data.dao.MatakuliahDao
import com.example.ucp2_pam.Data.entity.Matakuliah

// Mendefinisikan database Room dengan entitas mahasiswa
@Database(entities = [Matakuliah::class], version = 1, exportSchema = false)
abstract class DosenDatabase : RoomDatabase() {

    abstract fun matakuliahDao(): MatakuliahDao

    companion object {
        // Volatile untuk memastikan instance terbaru selalu terlihat oleh thread lain
        @Volatile
        private var instance: DosenDatabase? = null

        // Singleton pattern untuk memastikan hanya satu instance database yang digunakan
        fun getDatabase(context: Context): DosenDatabase {
            // Jika instance sudah ada, gunakan instance tersebut
            return instance ?: synchronized(this) {
                // Jika instance belum ada, buat menggunakan Room.databaseBuilder
                Room.databaseBuilder(
                    context.applicationContext, // Gunakan applicationContext untuk mencegah memory leak
                    DosenDatabase::class.java,    // Kelas database yang didefinisikan
                    "DosenDatabase"               // Nama database
                )
                    .build() // Membuat instance database
                    .also { instance = it } // Menyimpan instance ke variabel instance
            }
        }
    }
}