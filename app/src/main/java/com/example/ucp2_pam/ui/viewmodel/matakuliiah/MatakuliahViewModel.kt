package com.example.ucp2_pam.ui.viewmodel.matakuliiah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2_pam.repository.RepositoryMatakuliah
import kotlinx.coroutines.launch

class MatakuliahViewModel(private val repositoryMatakuliah: RepositoryMatakuliah): ViewModel() {
    var uiState by mutableStateOf(MatakuliahUIState())

    // memperbarui state berdasarkan input pengguna
    fun updateState(matakuliahEvent: MatakuliahEvent) {
        uiState = uiState.copy(
            matakuliahEvent = matakuliahEvent
        )
    }

    //validasi data inout pengguna
    private fun validateField(): Boolean {
        val event = uiState.matakuliahEvent
        val errorState = FormErrorState(
            kode = if (event.kode.isNotEmpty()) null else "kode tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "nama tidak boleh kosong",
            sks = if (event.sks.isNotEmpty()) null else "sks tidak boleh kosong",
            semester = if (event.semester.isNotEmpty()) null else "semester tidak boleh kosong",
            jenis = if (event.jenis.isNotEmpty()) null else "jenis tidak boleh kosong",
            dosenpengampu = if (event.dosenpengampu.isNotEmpty()) null else "dosenpengampu tidak boleh kosong"
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
    //menyimpan data ke repository
    fun saveData() {
        val currentEvent = uiState.matakuliahEvent
        if(validateField()){
            viewModelScope.launch {
                try{
                    repositoryMatakuliah.insertMtk(currentEvent.toMatakuliahEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "data berhasil disimpan",
                        matakuliahEvent = MatakuliahEvent(),
                        isEntryValid = FormErrorState()
                    )
                }catch (e: Exception){
                    uiState = uiState.copy(
                        snackBarMessage = "data gagal disimpan"
                    )
                }
            }
        }else{
            uiState=uiState.copy(
                snackBarMessage = "Input tidak valid periksa kembali data anda"
            )
        }
    }
    //reset pesan snackbar
    fun resetSnackBarMessage(){
        uiState=uiState.copy(snackBarMessage = null)
    }


}