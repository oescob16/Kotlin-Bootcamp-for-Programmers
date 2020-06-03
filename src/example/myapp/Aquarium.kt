package example.myapp

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("Aquarium Initializing")
    }
    init {
        println("Volume: ${width * length * height / 1000} l")
    }
    constructor(numberOfFish: Int): this(){
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }
    fun printSize(){
        println("Width: $width cm")
        println("Height: $height cm")
        println("Length: $length cm" + "\n")
    }
}