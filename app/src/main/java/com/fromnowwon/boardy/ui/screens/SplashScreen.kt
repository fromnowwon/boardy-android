package com.fromnowwon.boardy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, checkLoggedIn: () -> Boolean) {
    // 앱 이름 표시 상태
    var visible by remember { mutableStateOf(true) }

    // 앱 시작 시 동작
    LaunchedEffect(Unit) {
        delay(2000)
        visible = false

        // 로그인 상태 확인 후 이동
        if (checkLoggedIn()) {
            // 로그인 되어 있으면 MainScreen으로 이동
            navController.navigate("main") {
                // 스플래시 화면을 back stack에서 제거
                popUpTo("splash") { inclusive = true }
            }
        } else {
            // 로그인 안 되어 있으면 OnboardingScreen으로 이동
            navController.navigate("onboarding") {
                // 스플래시 화면을 back stack에서 제거
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize() // 전체 화면 차지
            .padding(16.dp),
        contentAlignment = Alignment.Center // 중앙 정렬
    ) {
        Text(
            text = "Boardy",
            style = MaterialTheme.typography.headlineLarge
        )
    }

}