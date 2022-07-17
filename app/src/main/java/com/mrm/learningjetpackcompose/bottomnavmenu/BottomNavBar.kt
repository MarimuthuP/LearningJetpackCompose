package com.mrm.learningjetpackcompose.bottomnavmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavBar(
        "home",
        "Home",
        Icons.Default.Home
    )

    object Profile : BottomNavBar(
        "profile",
        "Profile",
        Icons.Default.Person
    )

    object Settings : BottomNavBar(
        "settings",
        "Settings",
        Icons.Default.Settings
    )
}