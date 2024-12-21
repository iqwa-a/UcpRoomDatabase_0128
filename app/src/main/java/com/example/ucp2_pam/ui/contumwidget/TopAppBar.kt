package com.example.ucp2_pam.ui.contumwidget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    onBack: () -> Unit,
    showBackButton: Boolean = true,
    judul: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF180303), // Primary background color
    contentColor: Color = Color.Black // Text and icon color
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        if (showBackButton) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp), // Tambahkan padding kecil untuk estetika
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Menggunakan ikon panah kembali
                        contentDescription = "Back Icon",
                        tint = contentColor, // Warna ikon mengikuti `contentColor`
                        modifier = Modifier.size(50.dp) // Ukuran ikon diatur menjadi 24.dp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        // Centered title text
        Text(
            text = judul,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = contentColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}