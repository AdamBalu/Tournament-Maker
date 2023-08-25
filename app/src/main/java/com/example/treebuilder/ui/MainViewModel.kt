package com.example.treebuilder.ui

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.example.treebuilder.classes.SpiderMatch

class MainViewModel : ViewModel() {
    private val _contestantsNum = mutableIntStateOf(0)
    val contestantsNum: MutableIntState
        get() = _contestantsNum

    private val _tree = mutableListOf<SpiderMatch>()
    val tree: MutableList<SpiderMatch>
        get() = _tree

    private val _contestants = mutableListOf<String>()
    val contestants: MutableList<String>
        get() = _contestants

    fun setContestantsNum(fieldValue: String) {
        if (!fieldValue.isDigitsOnly()) return
        _contestantsNum.intValue = fieldValue.toInt()
    }

    fun generatePlayers() {
        _contestants.clear()
        for (i in 1.._contestantsNum.intValue) {
            _contestants.add("Player $i")
        }
    }

    fun generateTree() {
        val contestantsCopy = mutableListOf<String>()
        contestantsCopy.addAll(_contestants)
        contestantsCopy.shuffle()
        _tree.clear()
        for (i in 1..contestantsCopy.size step 2) {
            val contestantA = contestantsCopy[i - 1]
            val contestantB = if (i <= contestantsCopy.size - 1) contestantsCopy[i] else ""
            val newMatch = SpiderMatch(contestantA, contestantB, 0, 0)
            _tree.add(newMatch)
        }
        _tree.shuffle()
    }

    private fun getTreeSize(): Int {
        var i = 1
        while (_contestantsNum.intValue > i)
            i *= 2
        return i
    }

    fun changePlayerName(index: Int, value: String) {
        _contestants[index] = value
    }

    fun changeContestantName(index: Int, value: String, contestant: Int) {
        if (contestant == 1) {
            _tree[index].p1 = value
        } else {
            _tree[index].p2 = value
        }
    }
}