package com.fromnowwon.boardy.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * 앱 전역 SharedPreferences 관리
 */
class PrefsManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("boardy_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_FIRST_LAUNCH = "isFirstLaunch"
    }

    /** 첫 실행 여부 확인 */
    fun isFirstLaunch(): Boolean {
        return prefs.getBoolean(KEY_FIRST_LAUNCH, true) // 기본값 true
    }

    /** 온보딩 완료 후 첫 실행 플래그 false로 저장 */
    fun setFirstLaunchDone() {
        prefs.edit().putBoolean(KEY_FIRST_LAUNCH, false).apply()
    }
}