package com.rodrigo.myapplicationm

import android.content.Context
import android.content.SharedPreferences

class Session(context: Context) {

    private val security: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)



    fun storeString(name: String, value: String) {
        security.edit().putString(name, value).apply()
    }

    fun getString(name: String) : String {
        return security.getString(name, "") ?: ""
    }
}