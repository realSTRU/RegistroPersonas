package com.example.registropersonascompose.Nav

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registropersonascompose.ui.occupation.OccupationFormScreen
import com.example.registropersonascompose.ui.person.PersonFormScreen
import com.example.registropersonascompose.ui.person.PersonViewModel
import com.example.registropersonascompose.ui.person.PersonsConsultScreen

@Composable
fun AppNavigation(context: Context,
)
{
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.ConsultScreen.route
    ) {
        //Home Screen
        composable(AppScreens.ConsultScreen.route) {
           PersonsConsultScreen(navController = navController)
        }
        composable(AppScreens.FormScreen.route) {
            PersonFormScreen(context=context,navController = navController)
        }
        composable(AppScreens.OccupationsScreen.route){
            OccupationFormScreen(navController = navController)
        }
    }
}


