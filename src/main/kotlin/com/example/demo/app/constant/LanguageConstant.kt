package com.example.demo.app.constant

import java.util.Locale

object LanguageConstant {
    const val EN = "en"
    const val TH = "th"

    fun toLocale(locale: Locale): String{
        return when(locale.language)     {
            EN -> EN
            TH -> TH
            else -> EN
        }
    }
}