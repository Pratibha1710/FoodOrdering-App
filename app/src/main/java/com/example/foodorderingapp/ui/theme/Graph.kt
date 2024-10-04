package com.example.foodorderingapp.ui.theme

import android.content.Context
import com.example.foodorderingapp.model.DataStoreManager

object Graph {
    lateinit var dataStoreManager: DataStoreManager

    fun provide(context: Context) {
        dataStoreManager = DataStoreManager(context)
    }
}