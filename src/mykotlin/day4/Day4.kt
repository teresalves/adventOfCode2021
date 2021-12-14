package mykotlin.day4

import java.io.File
import kotlin.math.floor

class Day4 {
    companion object {
        fun a(): Int {
            val values = File("./src/mykotlin/day4/input4.txt").readLines()
            val inputs = values[0].split(',')
            val totalBingoCards = processInputs(values)

            return checkFirstToWin(inputs, totalBingoCards)

        }

        private fun processInputs(values: List<String>): MutableList<List<List<InputNumber>>> {
            val totalMatrices: Int = floor(((values.size - 1)/6).toDouble()).toInt()
            println(totalMatrices)
            var totalBingoMatrices = mutableListOf<List<List<InputNumber>>>()
            for(i in 0 until totalMatrices){
                val bingoMatrix = mutableListOf<List<InputNumber>>()
                for(j in 0 until 5){
                    val lineArray = mutableListOf<InputNumber>()
                    val lineValues = values[6*i + j + 2].split(' ').filter{ input -> input.isNotEmpty() }
                    for(k in 0 until 5){
                        println(lineValues[k])
                        lineArray.add(InputNumber(lineValues[k]))
                    }
                    bingoMatrix.add(lineArray)
                }
                totalBingoMatrices.add(bingoMatrix)
            }

            for(i in 0 until 5) {
                println(totalBingoMatrices[0][i].toString())
            }
            return totalBingoMatrices;
        }

        private fun checkFirstToWin(inputs: List<String>, totalBingoCards:  MutableList<List<List<InputNumber>>>): Int {
            for(input in inputs) {
                for(card in totalBingoCards){
                    val position = addInputToCard(card, input)
                    if(position.isValid()) {
                        val bingo = checkIfBingo(card, position)
                        if(bingo) {
                            return calculateResult(card, input.toInt())
                        }
                    }
                }
            }
            return -1
        }

        private fun addInputToCard(card: List<List<InputNumber>>, input: String): Position {
            for(i in 0 until 5){
                for(j in 0 until 5) {
                    val inputNumber = card[i][j]
                    if(inputNumber.getNumber() == input) {
                        inputNumber.setChecked()
                        return Position(i,j)
                    }
                }
            }
            return Position(-1,-1)
        }

        private fun checkIfBingo(card: List<List<InputNumber>>, position: Position): Boolean {
            // Check rows first
            var consecutiveElements = 0;
            consecutiveElements = 0;
            for(j in 0 until 5) {
                val inputNumber = card[position.row.toInt()][j]
                if(!inputNumber.getChecked()) {
                    break;
                }
                consecutiveElements++
            }
            if(consecutiveElements == 5) {
                return true
            }

            consecutiveElements = 0;
            for(i in 0 until 5) {
                val inputNumber = card[i][position.col.toInt()]
                if(!inputNumber.getChecked()) {
                    break;
                }
                consecutiveElements++
            }
            if(consecutiveElements == 5) {
                return true
            }
            return false;
        }

        private fun calculateResult(card: List<List<InputNumber>>, input: Int): Int {
            var result = 0
            for(i in 0 until 5) {
                for(j in 0 until 5) {
                    val inputNumber = card[i][j]
                    if(!inputNumber.getChecked()) {
                        result += inputNumber.getNumber().toInt()
                    }
                }
            }
            return result * input
        }
    }
}

