package com.example.ucp2_pam.ui.view.dosen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2_pam.ui.contumwidget.TopAppBar
import com.example.ucp2_pam.ui.viewmodel.dosen.DetailDosenViewModel
import com.example.ucp2_pam.ui.viewmodel.dosen.PenyediaDosenViewModel

@Composable
fun DetailDosenView(
    modifier: Modifier = Modifier,
    viewModel: DetailDosenViewModel = viewModel(factory = PenyediaDosenViewModel.Factory),
    onBack: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Detail Dosen",
                showBackButton = true,
                onBack = onBack,
                modifier = modifier
            )
        },
    ) { innerPadding ->
        val detailDosenUiState by viewModel.detailUiState.collectAsState()

        BodyDetailDosen(
            modifier = Modifier.padding(innerPadding),
            detailDosenUiState = detailDosenUiState,
        )
    }
}