package mykotlin.day4

class Position(_row: Int, _col: Int) {
    val row = _row
    val col = _col

    public fun isValid(): Boolean {
        return row != -1 && col != -1
    }
}