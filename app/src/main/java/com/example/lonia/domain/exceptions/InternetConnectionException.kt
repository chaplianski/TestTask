package com.example.lonia.domain.exceptions

import androidx.annotation.StringRes

class InternetConnectionException (@StringRes val errorMessage: Int): Exception() {
}