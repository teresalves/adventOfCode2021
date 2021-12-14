package mykotlin.day3

import java.io.File

class Day3 {
    companion object {
        fun a(): Int {
            val values = File("./src/mykotlin/day3/input3.txt").readLines()
            var gamma = mutableListOf<Char>()
            var epsilon = mutableListOf<Char>()
            var hashMap : HashMap<Char, Int> = HashMap<Char, Int> ()
            hashMap['0'] = 0; hashMap['1'] = 0
            for(j in values.elementAt(0).indices){
                for(i in values.indices) {
                    hashMap[values[i][j]] = hashMap[values[i][j]]!!.toInt() + 1
                }
                if(hashMap['0']!! >= hashMap['1']!!) {
                    gamma.add('0')
                    epsilon.add('1')
                }
                else {
                    gamma.add('1')
                    epsilon.add('0')
                }
                hashMap['0'] = 0
                hashMap['1'] = 0
            }

            return binToDec(gamma.joinToString("").toLong()) * binToDec(epsilon.joinToString("").toLong())
        }

        private fun binToDec(num: Long) : Int {
            var num = num
            var decimalNumber = 0
            var i = 0
            var remainder: Long

            while (num.toInt() != 0) {
                remainder = num % 10
                num /= 10
                decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
                ++i
            }
            return decimalNumber
        }
    }
}