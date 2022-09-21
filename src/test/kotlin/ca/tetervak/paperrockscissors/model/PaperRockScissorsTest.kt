package ca.tetervak.paperrockscissors.model

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.random.Random

internal class PaperRockScissorsTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun startAll() {
            println("--- Starting PaperRockScissors Tests ---")
        }

        @JvmStatic
        @AfterAll
        fun endAll() {
            println("--- End of PaperRockScissors Tests ---")
        }
    }

    @BeforeEach
    fun setUp() {
        println("--- testing case ---")
    }

    @AfterEach
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @ParameterizedTest
    @EnumSource
    fun sameChoice(choice: Choice){
        val gameData = PaperRockScissors.play(choice, choice)
        println("gameData = $gameData")
        assertEquals(GameResult.REPLAY, gameData.result)
    }

    @Test
    fun paperWinsRock(){
        val gameData1 = PaperRockScissors.play(Choice.PAPER, Choice.ROCK)
        println("gameData1 = $gameData1")
        assertEquals(GameResult.PLAYER_ONE_WINS, gameData1.result)
        val gameData2 = PaperRockScissors.play(Choice.ROCK, Choice.PAPER)
        println("gameData2 = $gameData2")
        assertEquals(GameResult.PLAYER_TWO_WINS, gameData2.result)
    }

    @Test
    fun scissorsWinPaper(){
        val gameData1 = PaperRockScissors.play(Choice.SCISSORS, Choice.PAPER)
        println("gameData1 = $gameData1")
        assertEquals(GameResult.PLAYER_ONE_WINS, gameData1.result)
        val gameData2 = PaperRockScissors.play(Choice.PAPER, Choice.SCISSORS)
        println("gameData2 = $gameData2")
        assertEquals(GameResult.PLAYER_TWO_WINS, gameData2.result)
    }

    @Test
    fun rockWinsScissors(){
        val gameData1 = PaperRockScissors.play(Choice.ROCK, Choice.SCISSORS)
        println("gameData1 = $gameData1")
        assertEquals(GameResult.PLAYER_ONE_WINS, gameData1.result)
        val gameData2 = PaperRockScissors.play(Choice.SCISSORS, Choice.ROCK)
        println("gameData2 = $gameData2")
        assertEquals(GameResult.PLAYER_TWO_WINS, gameData2.result)
    }

    @RepeatedTest(10)
    fun randomRuns(rep: RepetitionInfo){
        val random = Random(seed = rep.currentRepetition)
        val playerOneChoice = PaperRockScissors.getRandomChoice(random)
        val playerTwoChoice = PaperRockScissors.getRandomChoice(random)
        val gameData = PaperRockScissors.play(playerOneChoice, playerTwoChoice)
        println("gameData = $gameData")
    }

}