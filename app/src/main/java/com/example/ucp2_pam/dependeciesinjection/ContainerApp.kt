package com.example.ucp2_pam.dependeciesinjection

import android.content.Context

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMatakuliah: RepositoryMatakuliah by lazy {
        LocalRepositoryMatakuliah(DosenDatabase.getDatabase(context).matakuliahDao())
    }
}