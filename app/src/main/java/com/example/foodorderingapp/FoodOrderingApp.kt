package com.example.foodorderingapp

import android.app.Application
import com.example.foodorderingapp.ui.theme.Graph

class FoodOrderingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(context = this)
    }
}