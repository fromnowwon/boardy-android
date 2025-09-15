package com.fromnowwon.boardy.ui

import androidx.compose.runtime.Composable
import com.fromnowwon.boardy.ui.navigation.AppNavHost

@Composable
fun BoardyApp() {
    // 로그인 여부 확인
    val isLoggedIn: () -> Boolean = {
        false
    }

    AppNavHost(checkLoggedIn = isLoggedIn)
}