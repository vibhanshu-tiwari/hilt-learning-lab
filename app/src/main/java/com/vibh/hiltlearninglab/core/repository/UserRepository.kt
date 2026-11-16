package com.vibh.hiltlearninglab.core.repository

import android.content.SharedPreferences
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
}