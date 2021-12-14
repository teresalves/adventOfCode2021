

import java.io.File

fun day1() {
    val numbers = File("./src/kotlin/input1.txt").readLines()
    val result: MutableList<String> = mutableListOf()
    var size = 0;
    for(i in 0 until numbers.size-1) {
        if(numbers[i+1] > numbers[i]) {
            result.add(numbers[i + 1])
            size++
        }
    }
    println(size)
}