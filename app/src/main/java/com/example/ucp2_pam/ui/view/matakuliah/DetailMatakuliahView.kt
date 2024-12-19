import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2_pam.ui.contumwidget.TopAppBar

@Composable
fun DetailMatakuliahView(
    modifier: Modifier = Modifier,
    viewModel: DetailMatakuliahViewModel = viewModel(factory = penyediaMatakuliahViewModel.Factory),
    onBack: () -> Unit = {},
    onEditClick: (String) -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Detail Matakuliah",
                showBackButton = true,
                onBack = onBack,
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEditClick(viewModel.detailUiState.value.detailUiEvent.kode)
                },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Matakuliah"
                )
            }b
        }
    ) { innerPadding ->
        val detailUiState by viewModel.detailUiState.collectAsState()
        BodyDetailMatakuliah(
            modifier = Modifier.padding(innerPadding),
            detailUiState = detailUiState,
            onDeleteClick = {
                viewModel.deleteMatakuliah()
                onDeleteClick()
            },
        )
    }
}