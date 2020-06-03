import kotlin.random.Random
import java.util.*
import java.util.Random as rand

fun main(args: Array<String>) {
    feedTheFish1()
    println("----------------------------------")

    feedTheFish2()
    println("----------------------------------")

    swim()
    swim("Very slow")
    swim(speed="turtle-like")
    println("----------------------------------")

    val decorations = listOf("rock","pagoda","plastic plant","alligator","flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")
    println("----------------------------------")

    val lazy = decorations.asSequence().filter { it[0] == 'p' }
    println("lazy: $lazy")
    println("----------------------------------")

    val newList = lazy.toList()
    println("new list: $newList")
    println("----------------------------------")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazyMap: $lazyMap")
    println("----------------------------------")
    println("first: ${lazyMap.first()}")
    println("----------------------------------")
    println("all: ${lazyMap.toList()}")
    println("----------------------------------")

    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("Filtered: ${lazyMap2.toList()}")
}

fun feedTheFish1(){
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val week = arrayOf("Monday","Tuesday","Wednesday",
    "Thursday","Friday","Saturday","Sunday")
    return week[rand().nextInt(week.size)]
}

fun feedTheFish2() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun fishFood(day: String): String {
    return when(day){
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun swim(speed: String = "fast"){
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isSunday(day) -> true
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"