package com.example.ucp2_pam.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeView(
    onDosenClick: () -> Unit,
    onMataKuliahClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // State for animation control
    var isVisible by remember { mutableStateOf(false) }

    // Trigger animation when the view is loaded
    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black) //
    ) {
        // Include the TopAppBar at the top
        TopAppBar(
            onBack = {}, // No back action in HomeView
            showBackButton = false,
            judul = "SELAMAT DATANG ",
            backgroundColor = Color(0xFF343434),
            contentColor = Color.White // White text and icon
        )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Buttons with animations
            AnimatedButton(text = "Input Dosen",
                icon = Icons.Filled.Person, onClick = onDosenClick)
            AnimatedButton(text = "Input Matakuliah",
                icon = Icons.Filled.Edit, onClick = onMataKuliahClick)
        }
    }
}

@Composable
fun AnimatedButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF343434), // Warna latar tombol
            contentColor = Color.White // Warna teks
        ),
        shape = RectangleShape, // Bentuk tombol menjadi persegi
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 25.dp)
            .size(250.dp) // Ukuran panjang dan lebar sama
            .shadow(25.dp, shape = RectangleShape) // Bayangan berbentuk kotak
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Icon with increased size
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp) // Padding between icon and text
                    .size(50.dp), // Increased icon size
                tint = Color.White
            )
            // Text
            Text(
                text = text,
                fontSize = 18.sp, // Ukuran font teks
                fontWeight = FontWeight.Bold
            )
        }
    }
}
