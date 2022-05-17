package com.commandiron.tracker_presentation.search

import com.commandiron.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
) {
}