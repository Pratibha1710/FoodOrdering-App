package com.example.foodorderingapp.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderingapp.model.DataStoreManager
import com.example.foodorderingapp.navigation.OnBoardingRoute
import com.example.foodorderingapp.navigation.Tabs
import com.example.foodorderingapp.ui.theme.Graph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class OnBoardingViewModel(
    dataStoreManager: DataStoreManager = Graph.dataStoreManager
) : ViewModel() {
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _startDestination: MutableStateFlow<String> = MutableStateFlow(Tabs.Feed.route)
    val startDestination: StateFlow<String> = _startDestination.asStateFlow()

    init {
        viewModelScope.launch {

            val timeoutMillis = 5000L
            val onboardingState = withTimeout(timeoutMillis) {
                dataStoreManager.getOnBoardingState().first()
            }
            _startDestination.value = if (onboardingState) Tabs.Feed.route
            else OnBoardingRoute
            _isLoading.value = false
        }
    }

}