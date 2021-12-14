package mykotlin.day2

import java.io.File

class Day2 {
    companion object{
        fun a(): Int {
            val values = File("./src/mykotlin/day2/input2.txt").readLines()
            var horizontal = 0; var vertical = 0;
            for(value in values){
                var elems = value.split(' ');
                when(elems.elementAt(0) as String) {
                    "forward" -> horizontal +=(elems.elementAt(1)).toInt()
                    "down" -> vertical +=(elems.elementAt(1)).toInt()
                    "up" -> vertical -=(elems.elementAt(1)).toInt()
                }
            }

            return horizontal * vertical
        }
    }
}