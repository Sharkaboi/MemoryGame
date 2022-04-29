package extensions

fun <T> List<T>.duplicate(count: Int): List<T> {
    var list = this
    repeat(count) {
        list = list + this
    }
    return list
}