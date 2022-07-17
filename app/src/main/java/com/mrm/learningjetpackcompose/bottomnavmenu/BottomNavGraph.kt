package com.mrm.learningjetpackcompose.bottomnavmenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrm.learningjetpackcompose.bottomnavmenu.screens.HomeScreen
import com.mrm.learningjetpackcompose.bottomnavmenu.screens.ProfileScreen
import com.mrm.learningjetpackcompose.bottomnavmenu.screens.SettingScreen


@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavBar.Home.route
    ){
        composable(route = BottomNavBar.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavBar.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomNavBar.Settings.route){
            SettingScreen()
        }
    }
}