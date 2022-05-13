package com.commandiron.onboarding_domain.use_case

import com.commandiron.core.util.UiText
import com.commandiron.core.R

class ValidateNutrients {
    operator fun invoke(
        carbRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbRatio = carbRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()

        if(carbRatio == null || proteinRatio == null || fatRatio == null){
            return Result.Error(
                UiText.StringResource(R.string.error_invalid_values)
            )
        }
        if(carbRatio + proteinRatio + fatRatio != 100){
            return Result.Error(
                UiText.StringResource(R.string.error_not_100_percent)
            )
        }
        return Result.Success(
            carbRatio = carbRatio / 100f,
            proteinRatio = proteinRatio / 100f,
            fatRatio = fatRatio / 100f
        )
    }

    sealed class Result {
        data class Success(
            val carbRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()
        data class Error(val message: UiText): Result()
    }
}