package com.example.treebuilder.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.treebuilder.ViewModelProvider
import com.example.treebuilder.ui.MainViewModel
import com.example.treebuilder.ui.match.ScoreCounterViewModel
import com.example.treebuilder.ui.match.Table
import com.example.treebuilder.ui.spider.CreatingSpiderMainScreen
import com.example.treebuilder.ui.spider.ListOfPlayers
import com.example.treebuilder.ui.spider.SpiderMainScreen

@Composable
fun MainAppContent(
    mainViewModel: MainViewModel = viewModel(factory = ViewModelProvider.Factory),
    scoreCounterViewModel: ScoreCounterViewModel = viewModel(factory = ViewModelProvider.Factory)
) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeNavScreen.Home.name
    ) {
        composable(route = HomeNavScreen.Home.name) {
            HomeScreen(
                onStartMatch = { navController.navigate(HomeNavScreen.PlayingMatch.name) },
                onStartCreatingSpider = { navController.navigate(HomeNavScreen.StartCreatingSpider.name) }
            )
        }

        composable(route = HomeNavScreen.PlayingMatch.name) {
            Table(scoreCounterViewModel = scoreCounterViewModel)
        }

        composable(route = HomeNavScreen.StartCreatingSpider.name) {
            CreatingSpiderMainScreen(
                mainViewModel,
                onGeneratePlayers = { navController.navigate(HomeNavScreen.PlayerCreation.name) }
            )
        }

        composable(route = HomeNavScreen.PlayerCreation.name) {
            ListOfPlayers(
                mainViewModel,
                onCreateSpider = { navController.navigate(HomeNavScreen.Spider.name) }
            )
        }

        composable(route = HomeNavScreen.Spider.name) {
            SpiderMainScreen(mainViewModel)
        }
    }
}

@Composable
fun HomeScreen(
    onStartMatch: () -> Unit,
    onStartCreatingSpider: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onStartMatch,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(120.dp)
                .padding(top = 50.dp)
        ) {
            Text("PLAY")
        }

        Button(
            onClick = onStartCreatingSpider,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(120.dp)
                .padding(top = 50.dp)
        ) {
            Text("CREATE")
        }
    }
}