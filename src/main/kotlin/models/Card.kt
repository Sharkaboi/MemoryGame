package models

data class Card(
    val suit: Suit,
    val rank: Rank
)

enum class Rank {
    `1`,
    `2`,
    `3`,
    `4`,
    `5`,
    `6`,
    `7`,
    `8`,
    `9`,
    `10`,
    Jack,
    Queen,
    King,
    Ace
}

enum class Suit {
    HEARTS,
    SPADE,
    CLUBS,
    DIAMONDS,
    JOKER
}
