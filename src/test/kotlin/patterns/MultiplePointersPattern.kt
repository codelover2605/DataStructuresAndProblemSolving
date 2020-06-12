package patterns

import org.junit.jupiter.api.Test

class MultiplePointersPattern {

    /**
     * Left Pointer First, Right Pointer Last
     * If sum of left + right value is 0, that's our pair
     * If sum is greater than 0, decrement right
     * If sum is lesser than 0, increment left
     * Repeat until sum is 0 or left and right don't overlap
     */
    @Test
    fun `Find the first Pair in a sorted array where the sum is 0`() {
        val inputArray = arrayOf(-4, -3, -2, -1, 0, 1, 2, 8, 10)

        var left = 0
        var right = inputArray.size - 1
        var pair: Pair<Int, Int>? = null

        while (left < right) {
            val sum = inputArray[left] + inputArray[right]
            if (sum == 0) {
                pair = Pair(inputArray[left], inputArray[right])
                break
            }

            if (sum > 0) right--
            else left++
        }

        assert(pair == Pair(-2, 2)) { "Expected Pair: (-2, 2) But was: $pair" }
    }

    /**
     * Left Pointer first, Right Pointer 1
     * If the left and right pointer values are different, Increment and assign left with right
     * If the left and right pointer values are same, increment right until they are not same, Increment and assign left with right
     * Ex: 1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13 will become 1,2,3,4,7,12,13,7,12,12,13
     */
    @Test
    fun `Find the unique numbers in a sorted array`() {
        listOf(
            intArrayOf(1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13),
            intArrayOf(-2, -2, -1, -1, 0, 1)
        ).forEach { inputArray ->
            var left = 0
            var right = 1

            while (right < inputArray.size) {
                if(inputArray[left] != inputArray[right]) {
                    left++
                    inputArray[left] = inputArray[right]
                } else{
                    right++
                }
            }

            println("Unique Values of ${inputArray.joinToString(",")}: ${left + 1}")
        }
    }

    @Test
    fun `Reorder the array with even numbers first followed by odd numbers`() {
        val inputArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        var left = 0
        var right = 1

        while (right < inputArray.size && left < inputArray.size) {
            if (inputArray[right] % 2 != 0) {
                right++
            } else {
                left++
                val temp = inputArray[left]
                inputArray[left] = inputArray[right]
                inputArray[right] = temp
            }
        }

        println(inputArray.joinToString(","))
    }

    @Test
    fun `Are there Duplicates?`() {
        listOf(
            Pair(intArrayOf(1, 2, 3, 4, 4, 5), true),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6), false),
            Pair(intArrayOf(1, 222, 333, 34, 44, 99999, 2), false)
        ).forEach { inputPair ->
            val input = inputPair.first
            val expectedResult = inputPair.second
            var result = false

            var left = 0
            var right = 1
            while (left < input.size && right < input.size) {
                if (input[left] != input[right]) {
                    left++
                    right++
                } else {
                    result = true
                    break
                }
            }

            assert(result == expectedResult)
            { "Expected Duplicates found to be $expectedResult but was: $result for ${input.joinToString(",")}" }
        }
    }

    @Test
    fun `Given sorted array and target Average, find if a pair in array matches target average`() {
        listOf<Pair<IntArray, Number>>(
            Pair(intArrayOf(1, 3, 3, 5, 6, 7, 10, 12, 19), 8),
            Pair(intArrayOf(-1, 0, 3, 4, 5, 6), 4.1)
        ).forEach { inputPair ->
            val input = inputPair.first
            val expectedAverage = inputPair.second.toDouble()

            var start = 0
            var end = input.size - 1
            var pairFound = false

            while (start < end) {
                val average = (input[start] + input[end]).toDouble() / 2
                if (average == expectedAverage) {
                    pairFound = true
                    break
                }

                if (average < expectedAverage) start++
                else end--
            }

            val result = if (pairFound) "found (${input[start]}, ${input[end]})" else "not found"

            println("Pair $result for ${input.joinToString(",")} matching average $expectedAverage")
        }
    }

    @Test
    fun `Is Sub-Sequence ?`() {
        listOf(
            Pair("hello", "Hello world"),
            Pair("axy", "adxcpy"),
            Pair("abc", "acb")
        ).forEach { inputPair ->
            val string1 = inputPair.first.toLowerCase()
            val string2 = inputPair.second.toLowerCase().replace(" ", "")

            var subSequence = false

            var string1Pointer = 0
            var string2Pointer = 0

            while (string1Pointer < string1.length && string2Pointer < string2.length) {
                if (string1[string1Pointer] == string2[string2Pointer]) {
                    string1Pointer++
                }
                if (string1Pointer == string1.length) {
                    subSequence = true
                    break
                } else {
                    string2Pointer++
                }
            }

            println("$string1 is sub-sequence of $string2: $subSequence")
        }
    }


}