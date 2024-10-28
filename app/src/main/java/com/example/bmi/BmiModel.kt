package com.example.bmi

// BmiModel.kt
class BmiModel {
    fun calculateBmi(weight: Float, height: Float): Float {
        return if (height > 0) weight / (height * height) else 0f
    }

    fun isHealthy(bmi: Float): Boolean {
        return bmi in 18.5..24.9
    }
}
