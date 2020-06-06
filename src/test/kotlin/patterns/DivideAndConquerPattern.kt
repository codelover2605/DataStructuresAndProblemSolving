package patterns

import org.junit.jupiter.api.Test
import kotlin.math.floor

class DivideAndConquerPattern {

    @Test
    fun binarySearch() {
        val inputArray = intArrayOf(2, 5, 6, 9, 13, 15, 28, 30)
        val searchElement = 13

        var start = 0
        var end = inputArray.size - 1
        var middle = floor((start + end).toDouble() / 2).toInt()

        while (searchElement != middle && start <= end) {
            if(searchElement < inputArray[middle]) end = middle - 1
            else start = middle + 1
            middle = floor((start + end).toDouble() / 2).toInt()
        }

        if(inputArray[middle] != searchElement) println("$searchElement not found")
        else println("Index of $searchElement is $middle")
    }

}