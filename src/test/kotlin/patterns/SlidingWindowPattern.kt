package patterns

import jdk.nashorn.internal.objects.Global.Infinity
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

class SlidingWindowPattern {

    /**
     * Find the first sub Array Sum and store it in maxSum
     * Assign maxSum to tempSum
     * Iterate with starting index: SubArrayLength until End of Array
     * Subtract Array[counter - subArrayLength] , Add Array[ counter ] to tempSum
     * Reassign maxSum with max of tempSum and maxSum
     * Iterate till end of array
     */
    @Test
    fun `Find the max sub-Array Sum`() {
        val inputArray = intArrayOf(1, 2, 5, 2, 8, 1, 5)
        val subArrayLength = 4

        var maxSum = 0
        for (counter in 0 until subArrayLength) {
            maxSum += inputArray[counter]
        }

        var tempSum = maxSum

        for (counter in subArrayLength until inputArray.size) {
            tempSum = tempSum - inputArray[counter - subArrayLength] + inputArray[counter]
            maxSum = max(maxSum, tempSum)
        }

        assert(maxSum == 17) { "Expected MaxSum: 17 But was: $maxSum" }

    }

    @Test
    fun `Find the min subArray length`() {
        listOf(
            Pair(intArrayOf(2, 3, 1, 2, 4, 3), 7)
        ).forEach { inputPair ->
            val array = inputPair.first
            val sum = inputPair.second

            var start = 0
            var end = 0
            var totalSum = 0
            var minLength = Infinity.toInt()

            while (start < array.size) {
                if (totalSum < sum && end < array.size) {
                    totalSum += array[end]
                    end++
                } else if (totalSum >= sum) {
                    minLength = min(minLength, end - start)
                    totalSum -= array[start]
                    start++
                } else {
                    break
                }
            }

            println(
                """MinSubArray Length is $minLength 
                    |Sub Array is: ${array.slice(start - 1 until end).joinToString(",")}""".trimMargin()
            )
        }
    }

    @Test
    fun `Longest Sub-String with distinct characters`() {
        listOf(
            "thisisawesome",
            "thecatinthehat",
            "bbbb"
        ).forEach { inputString ->
            val seen = mutableMapOf<Char, Int>()
            var start = 0
            var longest = 0

            for (counter in inputString.indices) {
                val char = inputString[counter]
                if (seen.containsKey(char)) {
                    start = max(start, seen[char]!!)
                }

                longest = max(longest, counter - start + 1)

                // Store the index of the next Char so as to not double count
                seen[char] = counter + 1
            }

            println("Longest SubString for $inputString is: $longest")
        }

    }

}