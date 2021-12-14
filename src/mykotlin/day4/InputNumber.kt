package mykotlin.day4

class InputNumber (input_number: String){
    private val number: String = input_number
    private var checked: Boolean = false

    public fun setChecked() {
        checked = true;
    }

    @JvmName("getNumber1")
    public fun getNumber(): String {
        return number
    }

    public fun getChecked(): Boolean {
        return checked
    }

    public override fun toString(): String {
        return "number: $number"
    }
}