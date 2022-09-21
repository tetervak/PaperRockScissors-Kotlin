import ca.tetervak.paperrockscissors.model.Choice
import ca.tetervak.paperrockscissors.model.PaperRockScissors
import ca.tetervak.paperrockscissors.model.GameResult
import java.lang.NumberFormatException

fun main() {
    println("Paper Rock or Scissors Game")

    println("Enter your choice: 1 for Paper, 2 for Rock, and 3 for Scissors")
    val userInput = readln()
    try {
        val userInt = userInput.toInt()
        if(userInt in (1 .. 3)){
            val userChoice = Choice.values()[userInt - 1]
            val gameData = PaperRockScissors.play(playerTwoChoice = userChoice)
            println("Computer Choice: ${gameData.playerOneChoice}")
            println("Your choice: ${gameData.playerTwoChoice}")
            when(gameData.result){
                GameResult.PLAYER_ONE_WINS -> println("Computer wins.")
                GameResult.PLAYER_TWO_WINS -> println("You are the winner!")
                GameResult.REPLAY -> println("Replay.")
            }
        } else {
            println("Invalid input")
        }
    } catch (exception: NumberFormatException){
        println("Invalid input")
    }
}