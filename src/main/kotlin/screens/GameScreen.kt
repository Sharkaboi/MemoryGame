package screens

import CurrentGameState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.duplicate
import models.*
import theme.MGColors

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MemoryGameScreen() {
    val gameState = CurrentGameState.current

    if (gameState.value.timeStarted == 0L) {
        var currentId = 1
        gameState.value = gameState.value.copy(
            timeStarted = System.currentTimeMillis(),
            gameBoard = (1..10).map {
                CardState(
                    id = currentId++,
                    card = Card(
                        suit = Suit.values().random(),
                        rank = Rank.values().random()
                    )
                )
            }.duplicate(2).shuffled()
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Score : ${gameState.value.score}",
            color = MGColors.colorDark,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            modifier = Modifier.padding(50.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Adaptive(100.dp)
        ) {
            itemsIndexed(gameState.value.gameBoard) { index, cardState ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .defaultMinSize(minWidth = 100.dp, minHeight = 150.dp)
                        .alpha(if (cardState.isCardSolved) 0f else 1f)
                        .clickable {
                            if (gameState.value.selectedCard == null) {
                                gameState.value = gameState.value.copy(selectedCard = cardState)
                            } else if (gameState.value.selectedCard?.id == cardState.id) {
                                gameState.value = gameState.value.copy(
                                    selectedCard = null
                                )
                            } else if(gameState.value.selectedCard?.card == cardState.card){
                                gameState.value = gameState.value.copy(
                                    score = gameState.value.score + 1,
                                    selectedCard = null,
                                    gameBoard = gameState.value.gameBoard.setPairAsSolved(gameState.value.selectedCard?.id,cardState.id)
                                )
                            }
                        }
                ) {
                    if (gameState.value.selectedCard?.id == cardState.id) {
                        Text(cardState.card.rank.name + ' ' + cardState.card.suit.name)
                    } else {
                        Text("Card")
                    }
                }
            }
        }
    }
}
