package com.benedetti.TP1.models

import java.sql.Date

data class task(val nom: String, val pourcentAvance: Int, val pourcentEcoule: Int, val endDate: Date) {
}