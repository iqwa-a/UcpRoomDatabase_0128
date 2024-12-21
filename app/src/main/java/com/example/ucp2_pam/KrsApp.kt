package com.example.ucp2_pam

import android.app.Application
import com.example.ucp2_pam.dependeciesinjection.ContainerApp

class KrsApp : Application() {

    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()

        containerApp = ContainerApp(this)
    }
}