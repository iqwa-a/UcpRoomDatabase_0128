package com.example.ucp2_pam.dependeciesinjection

import android.content.Context
import com.example.ucp2_pam.Data.database.KrsDatabase
import com.example.ucp2_pam.repository.LocalRepositoryDosen
import com.example.ucp2_pam.repository.LocalRepositoryMatakuliah
import com.example.ucp2_pam.repository.RepositoryDosen
import com.example.ucp2_pam.repository.RepositoryMatakuliah


interface InterfaceContainerApp {
    val repositoryMatakuliah : RepositoryMatakuliah
    val repositoryDosen: RepositoryDosen


}
class ContainerApp(private val context: Context) : InterfaceContainerApp {

    override val repositoryMatakuliah: RepositoryMatakuliah by lazy {
        LocalRepositoryMatakuliah(KrsDatabase.getDatabase(context).matakuliahDao())
    }
    override val repositoryDosen: RepositoryDosen by lazy {
        LocalRepositoryDosen(KrsDatabase.getDatabase(context).dosenDao())
    }

}