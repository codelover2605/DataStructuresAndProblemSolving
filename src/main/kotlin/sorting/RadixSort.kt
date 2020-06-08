package sorting

import kotlin.math.*

object RadixSort {

    /**
     * Figure out how many digits the largest number in the array has, loop from o until largestNumber digits
     * For each iteration of the loop, Create buckets for each digit (0-9), place each number in the array into the corresponding buckets
     * Replace the array with he values in the bucket
     */
    fun sort(array: IntArray): IntArray {
        var inputArray = array
        val maxDigits = digitCount(maxDigits(array))
        for (counter in 0 until maxDigits) {
            var digitBuckets = arrayOf<IntArray>()
            for (index in 0..9) {
                digitBuckets = digitBuckets.plus(intArrayOf())
            }

            for (innerCounter in inputArray.indices) {
                val digit = getDigit(inputArray[innerCounter], counter)
                digitBuckets[digit] = digitBuckets[digit].plus(inputArray[innerCounter])
            }

            inputArray = digitBuckets.flatMap { it.asIterable() }.toIntArray()
        }

        return inputArray
    }

    private fun getDigit(num: Int, base: Number): Int {
        return (floor(abs(num) / 10.0.pow(base.toDouble())) % 10).toInt()
    }

    private fun digitCount(num: Int): Int {
        return (floor(log10(abs(num.toDouble()))) + 1).toInt()
    }

    private fun maxDigits(array: IntArray): Int {
        var maxDigits = 0
        for (counter in array.indices) {
            maxDigits = max(maxDigits, array[counter])
        }

        return maxDigits
    }

}