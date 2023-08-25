package com.example.treebuilder.ui.match

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.treebuilder.Constants.PLAYER_ONE
import com.example.treebuilder.Constants.PLAYER_TWO
import com.example.treebuilder.Constants.SET_MAX_POINTS
import com.example.treebuilder.classes.MatchStats

class ScoreCounterViewModel : ViewModel() {
    private val _servingPlayer = mutableIntStateOf(0)
    val servingPlayer: MutableState<Int>
        get() = _servingPlayer

    private val _p1Score = mutableIntStateOf(0)
    val p1Score: MutableState<Int>
        get() = _p1Score

    private val _p2Score = mutableIntStateOf(0)
    val p2Score: MutableState<Int>
        get() = _p2Score

    private val _p1SetScore = mutableIntStateOf(0)
    val p1SetScore: MutableState<Int>
        get() = _p1SetScore

    private val _p2SetScore = mutableIntStateOf(0)
    val p2SetScore: MutableState<Int>
        get() = _p2SetScore

    private val _setEnded = mutableStateOf(false)
    val setEnded: MutableState<Boolean>
        get() = _setEnded

    private val _matchHistory = mutableListOf<MatchStats>()

    private fun increaseScore(p: Int) {
        if (!checkIfSetEnded()) {
            if (p == PLAYER_ONE) {
                _p1Score.intValue += 1
            } else if (p == PLAYER_TWO) {
                _p2Score.intValue += 1
            }
        }
    }

    fun onBackPress() {
        if (_matchHistory.isEmpty()) return
        var lastAction = _matchHistory.last()
        if (checkValuesMatch(lastAction)) {
            _matchHistory.removeLastOrNull()
            if (_matchHistory.isEmpty()) return
            lastAction = _matchHistory.last()
        }
        _p1Score.intValue = lastAction.p1score
        _p2Score.intValue = lastAction.p2score
        _p1SetScore.intValue = lastAction.p1SetScore
        _p2SetScore.intValue = lastAction.p2SetScore
        _servingPlayer.intValue = lastAction.servingPlayer
        _setEnded.value = lastAction.setEnded
    }

    private fun checkValuesMatch(lastAction: MatchStats): Boolean =
        _p1Score.intValue == lastAction.p1score &&
        _p2Score.intValue == lastAction.p2score &&
        _p1SetScore.intValue == lastAction.p1SetScore &&
        _p2SetScore.intValue == lastAction.p2SetScore &&
        _servingPlayer.intValue == lastAction.servingPlayer

    private fun updateServingPlayer() {
        if ((_p1Score.intValue + _p2Score.intValue) % 2 == 0) {
            if (_servingPlayer.intValue == PLAYER_ONE) {
                _servingPlayer.intValue = PLAYER_TWO
            } else if (_servingPlayer.intValue == PLAYER_TWO) {
                _servingPlayer.intValue = PLAYER_ONE
            }
        }
    }

    private fun setServingPlayer(player: Int) {
        if (_p1Score.intValue == 0 &&
            _p2Score.intValue == 0 &&
            _servingPlayer.intValue == 0) {
            _servingPlayer.intValue = player
            addMatchStat(
                _p1Score.intValue,
                _p2Score.intValue,
                _p1SetScore.intValue,
                _p2SetScore.intValue,
                _servingPlayer.intValue,
                _setEnded.value
            )
        }
    }

    private fun updateSets() {
        if (_p1Score.intValue >= SET_MAX_POINTS || _p2Score.intValue >= SET_MAX_POINTS) {
            if (kotlin.math.abs(_p1Score.intValue - _p2Score.intValue) <= 1)
                return
            if (_p1Score.intValue >= SET_MAX_POINTS && (_p1Score.intValue > _p2Score.intValue)) {
                _p1SetScore.intValue++
                _setEnded.value = true
            }
            if (_p2Score.intValue >= SET_MAX_POINTS && (_p1Score.intValue < _p2Score.intValue)) {
                _p2SetScore.intValue++
                _setEnded.value = true
            }
        }
    }

    private fun checkIfSetEnded() : Boolean {
        var setEnded = false
        if (_p1Score.intValue >= SET_MAX_POINTS || _p2Score.intValue >= SET_MAX_POINTS) {
            if (kotlin.math.abs(_p1Score.intValue - _p2Score.intValue) <= 1)
                return false
            if (_p1Score.intValue >= SET_MAX_POINTS && (_p1Score.intValue > _p2Score.intValue)) {
                setEnded = true
            }
            if (_p2Score.intValue >= SET_MAX_POINTS && (_p1Score.intValue < _p2Score.intValue)) {
                setEnded = true
            }
        }
        return setEnded
    }

    fun clearScores(matchReset: Boolean) {
        if (_p1SetScore.intValue >= 10 || _p2SetScore.intValue >= 10 || matchReset) {
            _p1SetScore.intValue = 0
            _p2SetScore.intValue = 0
        }
        _p1Score.intValue = 0
        _p2Score.intValue = 0
        _servingPlayer.intValue = 0
    }

    fun updateScores(currentPlayerButtonPressed: Int) {
        if (_matchHistory.isEmpty()) {
            addMatchStat(
                _p1Score.intValue,
                _p2Score.intValue,
                _p1SetScore.intValue,
                _p2SetScore.intValue,
                _servingPlayer.intValue,
                _setEnded.value
            )
        }

        if (_servingPlayer.intValue == 0) {
            _setEnded.value = false
            setServingPlayer(currentPlayerButtonPressed)
        } else {
            if (!_setEnded.value) {
                increaseScore(currentPlayerButtonPressed)
                updateServingPlayer()
                updateSets()
                addMatchStat(
                    _p1Score.intValue,
                    _p2Score.intValue,
                    _p1SetScore.intValue,
                    _p2SetScore.intValue,
                    _servingPlayer.intValue,
                    _setEnded.value
                )
            } else {
                clearScores(false)
                addMatchStat(
                    _p1Score.intValue,
                    _p2Score.intValue,
                    _p1SetScore.intValue,
                    _p2SetScore.intValue,
                    _servingPlayer.intValue,
                    true
                )
                _setEnded.value = false
            }
        }
    }


    private fun addMatchStat(
        p1Score: Int,
        p2Score: Int,
        p1SetScore: Int,
        p2SetScore: Int,
        servingPlayer: Int,
        setEnded: Boolean
    ) {
        val stats = MatchStats()
        stats.p1score = p1Score
        stats.p2score = p2Score
        stats.p1SetScore = p1SetScore
        stats.p2SetScore = p2SetScore
        stats.servingPlayer = servingPlayer
        stats.setEnded = setEnded
        _matchHistory.add(stats)
    }
}