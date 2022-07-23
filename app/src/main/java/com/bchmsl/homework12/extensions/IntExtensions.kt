package com.bchmsl.homework12.extensions

import java.text.NumberFormat
import java.util.*

fun Int.toEuro(): String? {
    val numberFormatter = NumberFormat.getCurrencyInstance()
    numberFormatter.maximumFractionDigits = 0
    numberFormatter.currency = Currency.getInstance("EUR")
    return numberFormatter.format(this)
}