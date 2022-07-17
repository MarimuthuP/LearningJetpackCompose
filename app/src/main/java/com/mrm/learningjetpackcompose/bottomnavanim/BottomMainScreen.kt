package com.mrm.learningjetpackcompose.bottomnavanim

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.mrm.learningjetpackcompose.R


sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector){
    object Frankendroid: BottomNavigationScreens("frankendroid", R.string.frankendroid_route, Icons.Filled.Terrain)
    object Pumpkin: BottomNavigationScreens("pumpkin", R.string.pumpkin_screen_route, Icons.Filled.FoodBank)
    object Ghost: BottomNavigationScreens("ghost", R.string.ghost_screen_route, Icons.Filled.Fireplace)
    object ScaryBag: BottomNavigationScreens("scarybag", R.string.scary_bag_screen_route, Icons.Filled.Cake)
}

sealed class ScaryAnimation(val animId: Int){
    object Frankendroid: ScaryAnimation(R.raw.frankensteindroid)
    object Pumpkin: ScaryAnimation(R.raw.jackolantern)
    object Ghost: ScaryAnimation(R.raw.ghost)
    object ScaryBag: ScaryAnimation(R.raw.bag)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomMainScreen(){
    val navController = rememberNavController()
    val bottomNavigationItem = listOf(
        BottomNavigationScreens.Frankendroid,
        BottomNavigationScreens.Pumpkin,
        BottomNavigationScreens.Ghost,
        BottomNavigationScreens.ScaryBag
    )
    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItem)
    }) {
        MainScreenNavigationGraph(navController)
    }
}

@Composable
fun MainScreenNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationScreens.Frankendroid.route){
        composable(BottomNavigationScreens.Frankendroid.route){
            ScaryScreen(ScaryAnimation.Frankendroid)
        }
        composable(BottomNavigationScreens.Pumpkin.route){
            ScaryScreen(ScaryAnimation.Pumpkin)
        }
        composable(BottomNavigationScreens.Ghost.route){
            ScaryScreen(ScaryAnimation.Ghost)
        }
        composable(BottomNavigationScreens.ScaryBag.route){
            ScaryScreen(ScaryAnimation.ScaryBag)
        }
    }
}

@Composable
fun ScaryScreen(scaryAnimation: ScaryAnimation) {
    val context = LocalContext.current
    val customView = remember {
        LottieAnimationView(context)
    }
    AndroidView({customView}, modifier = Modifier.background(Color.Black)){ view ->
        with(view){
            setAnimation(scaryAnimation.animId)
            playAnimation()
            repeatMode = LottieDrawable.REVERSE
        }
    }
}

@Composable
fun AppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation icon")},
                label = { Text(text = stringResource(id = screen.resourceId))},
                selected = currentRoute == screen.route,
                alwaysShowLabel = false,
                onClick = {
                    if (currentRoute!=screen.route){
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
