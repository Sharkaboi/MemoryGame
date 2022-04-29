package models

data class GameState(
    val score: Long = 0L,
    val timeStarted: Long = 0,
    val selectedCard: CardState? = null,
    val gameBoard: List<CardState> = emptyList()
)
