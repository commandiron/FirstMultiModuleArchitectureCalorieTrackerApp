package com.commandiron.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.commandiron.core.domain.model.Gender
import com.commandiron.core.domain.preferences.Preferences
import com.commandiron.core.navigation.Route
import com.commandiron.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel()  {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    //Bunu state şeklide yaparsak mesela screen orientation değişiminde istenmeyen sonuçlar
    //elde edebiliriz. O yüzden channel kullanıyoruz.
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender){
        selectedGender = gender
    }

    fun onNextClick(){
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiEvent.send(UiEvent.Navigate(Route.AGE))
        }
    }
}