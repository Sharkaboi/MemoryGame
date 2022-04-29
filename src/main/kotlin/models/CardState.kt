package models

data class CardState(
    val id: Int = 0,
    val isCardSolved: Boolean = false,
    val card: Card
)

private fun List<CardState>.setPairAsSolved(id1: Int?, id2: Int): List<CardState> {
    require(id1 != null)
}