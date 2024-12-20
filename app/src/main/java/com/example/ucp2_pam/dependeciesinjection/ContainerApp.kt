package com.example.ucp2_pam.dependeciesinjection

import android.content.Context
import com.example.ucp2_pam.Data.database.KrsDatabase
import com.example.ucp2_pam.repository.RepositoryMatakuliah


interface InterfaceContainerApp {
    val repositoryMatakuliah : RepositoryMatakuliah

}
class ContainerApp(private val context: Context) : InterfaceContainerApp {

    override val repositoryMatakuliah: RepositoryMatakuliah by lazy {
        LocalRepositoryMatakuliah(KrsDatabase.getDatabase(context).matakuliahDao())
    }

}