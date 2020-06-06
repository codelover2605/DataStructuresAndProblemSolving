package patterns

import org.junit.jupiter.api.Test
import kotlin.math.max

class SlidingWindowPattern {

    /**
     * Find the first sub Array Sum and store it in maxSum
     * Iterate with starting index: SubArrayLength and End of Array
     * Subtract Array[counter - subArrayLength] and Add Array[ counter ] to the sumCalculated and store the value in tempSum
     * Get the max of tempSum and maxSum until the end of iteration
     */
    @Test
    fun `Find the max sub-Array Sum`() {
        val inputArray = intArrayOf(1, 2, 5, 2, 8, 1, 5)
        val subArrayLength = 4
        var maxSum = 0

        for (counter in 0 until subArrayLength) maxSum += inputArray[counter]

        var tempSum = maxSum

        for (counter in subArrayLength until inputArray.size) {
            tempSum = tempSum - inputArray[counter - subArrayLength] + inputArray[counter]
            maxSum = max(maxSum, tempSum)
        }

        println("Max SubArray Sum: $maxSum")

    }

}