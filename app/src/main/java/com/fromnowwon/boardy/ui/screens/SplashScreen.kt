package com.fromnowwon.boardy.ui.screens

import com.fromnowwon.boardy.utils.PrefsManager
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, checkLoggedIn: () -> Boolean) {
    val context = LocalContext.current

    // SharedPreferences 관리 클래스 초기화
    val prefsManager = remember { PrefsManager(context) }

    // 앱 이름 표시 상태
    var visible by remember { mutableStateOf(true) }

    // 앱 시작 시 동작
    LaunchedEffect(Unit) {
        delay(2000)
        visible = false

        // 온보딩 완료 여부 확인
        val isFirstLaunch = prefsManager.isFirstLaunch()

        when {
            isFirstLaunch -> {
                // 처음 실행 시 → 온보딩 화면으로
                navController.navigate("onboarding") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            checkLoggedIn() -> {
                // 로그인되어 있으면 메인 화면으로
                navController.navigate("main") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            else -> {
                // 로그인 안 되어 있으면 로그인 화면으로
                navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Boardy",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }

}