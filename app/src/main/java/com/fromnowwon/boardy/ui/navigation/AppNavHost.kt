package com.fromnowwon.boardy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fromnowwon.boardy.ui.screens.*

/**
 * 앱 내 화면을 관리하는 NavHost
 */
@Composable
fun AppNavHost(checkLoggedIn: () -> Boolean) {
    // NavController 생성
    val navController: NavHostController = rememberNavController()

    // NavHost: 시작 화면을 SplashScreen으로 설정
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        // SplashScreen
        composable("splash") {
            SplashScreen(
                navController = navController,
                checkLoggedIn = checkLoggedIn // 로그인 여부 체크 함수 전달
            )
        }
        // Onboarding / 로그인 안내 화면
        composable("onboarding") {
            OnboardingScreen(navController)
        }

        // Main 화면
        composable("main") {
            MainScreen(navController)
        }

        // 로그인 화면
        composable("login") {
            LoginScreen(navController)
        }

        // 회원가입 화면
        composable("signup") {
            SignUpScreen(navController)
        }
    }
}