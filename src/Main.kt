fun main() {
    val arrayOne = arrayOf(25, 4, 88, 95, 2, 39, 44)
    println(arrayOne.contentDeepToString() + " - ${arrayOne[0].javaClass.name.substringAfterLast(".")}")
    val statesOne = States<Int>()
    println(statesOne.getAverage(arrayOne))

    val arrayTwo = arrayOf(25.0, 4.0, 88.0, 95.0, 2.0, 39.0, 44.0)
    println(arrayTwo.contentDeepToString() + " - ${arrayTwo[0].javaClass.name.substringAfterLast(".")}")
    val statesTwo = States<Double>()
    println(statesTwo.getAverage(arrayTwo))

    val arrayThree = arrayOf(25L, 4L, 88L, 95L, 2L, 39L, 44L)
    println(arrayThree.contentDeepToString() + " - ${arrayThree[0].javaClass.name.substringAfterLast(".")}")
    val statesThree = States<Long>()
    println(statesThree.getAverage(arrayThree))

    val arrayFour: Array<Byte> = arrayOf(25, 4, 88, 95, 2, 39, 44)
    println(arrayFour.contentDeepToString() + " - ${arrayFour[0].javaClass.name.substringAfterLast(".")}")
    val statesFour = States<Byte>()
    println(statesFour.getAverage(arrayFour))
    println()

    val genericMethod = GenericMethod()
    val arrayFive = arrayOf("Создать", "класс", "имени", "GenericMethod", "обобщенную", "функцию")
    println(arrayFive.contentDeepToString() + " - ${arrayFive[0].javaClass.name.substringAfterLast(".")}")
    val value = "имени"
    println(value)
    println(genericMethod.isItIncluded(arrayFive, value))

    val arraySix = arrayOf(true, true, true, true, false)
    println(arraySix.contentDeepToString() + " - ${arraySix[0].javaClass.name.substringAfterLast(".")}")
    val valueBoolean = false
    println(valueBoolean)
    println(genericMethod.isItIncluded(arraySix, valueBoolean))

    println(arrayTwo.contentDeepToString() + " - ${arrayTwo[0].javaClass.name.substringAfterLast(".")}")
    val valueDouble = 95.5
    println(valueDouble)
    println(genericMethod.isItIncluded(arrayTwo, valueDouble))
}

/*
Создать обобщенный класс States, который содержит функцию getAverage(), возвращающую среднее значение массива чисел.
Класс имеет ограничение, работать может только с числовыми значениями, T:Number.
*/
class States<T : Number>() {

    fun getAverage(array: Array<T>): Double {
        var result = 0.0
        array.forEach { a -> result += a.toDouble() }
        return result / array.size
    }
}

/*
Создать класс по имени GenericMethod и обобщенную функцию внутри класса по имени isItIncluded().
Функция isItIncluded() определяет, является ли объект членом массива.
Он может быть использован с любым типом объектов и массивов до тех пор, пока массив содержит объекты,
совместимые с типом искомого объекта.
*/
class GenericMethod() {

    fun <T> isItIncluded(array: Array<T>, value: T): Boolean {
        array.forEach { a -> if (value == a) return true }
        return false
    }
}