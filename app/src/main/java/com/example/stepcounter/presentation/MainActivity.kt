/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.stepcounter.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController


import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalWearMaterialApi::class)
@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()

    val pagerState = rememberPagerState(
        initialPage = 0,
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        SwipeDismissableNavHost(
            navController = navController,
            startDestination = "start",
        ) {
            composable(route = "start") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { navController.navigate("second") }) {
                        Text("Pager")
                    }
                }
            }
            composable(route = "second") {
                val state = rememberPagerState()
                val shape = if (LocalConfiguration.current.isScreenRound) CircleShape else null
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val pagerState = rememberPagerState()

                    HorizontalPager(
                        modifier = Modifier.fillMaxSize(),
                        count = 2,
                        state = pagerState
                    ) { page ->
                        if (page == 0) {
                            Box(

                            ) {
                                Text("Esta es la página 1")
                            }
                        }
                        if (page == 1) {
                            Box(

                            ) {
                                Text("Esta es la página 2")
                            }
                        }

                        /* Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "Screen $page")
                                }*/


                    }


                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp),
                        activeColor = MaterialTheme.colors.primary,
                    )

                }
                    /*ActionsRow(
                        pagerState = pagerState,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )*/
            }
        }
    }
}

