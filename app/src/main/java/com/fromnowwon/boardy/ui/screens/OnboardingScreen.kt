package com.fromnowwon.boardy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fromnowwon.boardy.utils.PrefsManager

@Composable
fun OnboardingScreen(navController: NavController) {
    val context = LocalContext.current
    val prefsManager = PrefsManager(context)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // 앱 소개
            Text(
                text = "Boardy에 오신 것을 환영합니다!",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(40.dp))

            // 시작 버튼
            Button(
                onClick = {
                    // 온보딩 완료 플래그 저장
                    prefsManager.setFirstLaunchDone()

                    // 로그인 화면으로 이동
                    navController.navigate("login") {
                        // 온보딩 화면을 스택에서 제거
                        popUpTo("onboarding") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Boardy 시작하기")
            }
        }
    }
}