package com.commandiron.core.domain.model

sealed class GoalType(val name: String) {
    object LoseWeight: GoalType("loseweight")
    object KeepWeight: GoalType("keepweight")
    object GainWeight: GoalType("gainweight")

    companion object {
        fun fromString(name: String): GoalType {
            return when(name) {
                "loseweight" -> LoseWeight
                "keepweight"-> KeepWeight
                "gainweight"-> GainWeight
                else -> LoseWeight //Hangisi olduğu önemli değil.
            }
        }
    }
}