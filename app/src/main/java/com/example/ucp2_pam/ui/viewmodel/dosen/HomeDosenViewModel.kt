package com.example.ucp2_pam.ui.viewmodel.dosen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2_pam.Data.entity.Dosen
import com.example.ucp2_pam.repository.RepositoryDosen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeDosenViewModel(
    private val repositoryDosen: RepositoryDosen
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> = repositoryDosen.getAllDsn()
        .filterNotNull() // Menghapus data null dari flow
        .map {
            HomeUiState(
                listDsn = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            // Emit state loading sebelum data mulai diterima
            emit(HomeUiState(isLoading = true))
            delay(900) // Simulasi delay
        }
        .catch {
            // Menangkap error dan mengupdate UI state dengan pesan error
            emit(
                HomeUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiState(isLoading = true)
        )
}

// Data class untuk merepresentasikan UI State
data class HomeUiState(
    val listDsn: List<Dosen> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)