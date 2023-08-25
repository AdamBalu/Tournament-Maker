package com.example.treebuilder

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.treebuilder.ui.MainViewModel
import com.example.treebuilder.ui.match.ScoreCounterViewModel

object ViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ScoreCounterViewModel()
        }
        initializer {
            MainViewModel()
        }
    }
}