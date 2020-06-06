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
    fun `Find the first Pair Where the sum is 0`() {
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
    fun `Find the unique numbers in an array`() {
        listOf(
            intArrayOf(1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13),
            intArrayOf(-2, -2, -1, -1, 0, 1)
        ).forEach { inputArray ->
            var left = 0
            var right = 1

            while (right < inputArray.size) {
                if (inputArray[left] == inputArray[right]) {
                    right++
                } else {
                    left++
                    inputArray[left] = inputArray[right]
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

        while(right < inputArray.size && left < inputArray.size) {
            if(inputArray[right] % 2 != 0) {
                right++
            } else{
                left++
                val temp = inputArray[left]
                inputArray[left] = inputArray[right]
                inputArray[right] = temp
            }
        }

        println(inputArray.joinToString(","))
    }

}