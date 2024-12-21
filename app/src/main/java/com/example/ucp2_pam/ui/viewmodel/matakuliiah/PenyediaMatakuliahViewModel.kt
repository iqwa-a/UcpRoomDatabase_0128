package com.example.ucp2_pam.ui.viewmodel.matakuliiah

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

object PenyediaMatakuliahViewModel {

    val Factory = viewModelFactory {
        initializer {
            MatakuliahViewModel(
                KrsApp().containerApp.repositoryMatakuliah
            )
        }
        initializer {
            HomeMatakuliahViewModel(
                KrsApp().containerApp.repositoryMatakuliah,
            )
        }
        initializer {
            DetailMatakuliahViewModel(
                createSavedStateHandle(),
                KrsApp().containerApp.repositoryMatakuliah,
            )
        }
        initializer {
            UpdateMatakuliahViewModel(
                createSavedStateHandle(),
                KrsApp().containerApp.repositoryMatakuliah,
            )
        }
    }
}

fun CreationExtras.KrsApp(): KrsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)

