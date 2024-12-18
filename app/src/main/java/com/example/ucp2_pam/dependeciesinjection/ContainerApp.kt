package com.example.ucp2_pam.dependeciesinjection

import android.content.Context


interface InterfaceContainerApp {
    val repositoryMatakuliah : RepositoryMatakuliah
}
class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMatakuliah: RepositoryMatakuliah by lazy {
        LocalRepositoryMatakuliah(DosenDatabase.getDatabase(context).matakuliahDao())
    }
}