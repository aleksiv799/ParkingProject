package data

data class Car(
    val model: String,
    val color: String,
    val number: String,
    val owner: Owner) {

    override fun toString(): String {
        return "Model: $model, color: $color, number: $number"
    }
}