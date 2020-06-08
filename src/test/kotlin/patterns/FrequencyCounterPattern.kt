package patterns

import org.junit.jupiter.api.Test

class FrequencyCounterPattern {

    @Test
    fun `Validate if every value in an array has its value squared in second array`() {
        val array1 = intArrayOf(1, 2, 3, 2)
        val array2 = intArrayOf(9, 4, 1, 4)

        var arrayContainsSquared = true

        if (array1.size != array2.size) {
            println("Array 1 and Array 2 Length not same")
        }

        val array1FrequencyCounter = mutableMapOf<Int, Int>()
        for (counter in array1.indices) {
            array1FrequencyCounter[array1[counter]] = array1FrequencyCounter[array1[counter]]?.plus(1) ?: 1
        }

        val array2FrequencyCounter = mutableMapOf<Int, Int>()
        for (counter in array2.indices) {
            array2FrequencyCounter[array2[counter]] = array2FrequencyCounter[array2[counter]]?.plus(1) ?: 1
        }

        array1FrequencyCounter.forEach { (key, value) ->
            if (!array2FrequencyCounter.containsKey(key * key)) {
                arrayContainsSquared = false
            }

            if (value != array2FrequencyCounter[key * key]) {
                arrayContainsSquared = false
            }
        }

        assert(arrayContainsSquared) { "Array 2 doesn't contain squared values of Array 1" }
    }

    @Test
    fun anagrams() {
        val inputPairs = listOf(
            Pair("rail safety", "fairy tales"),
            Pair("RAIL! SAFETY", "FairyTales"),
            Pair("texttwisttime", "timetwisttext")
        )

        inputPairs.forEach { inputPair ->
            val lookUp = mutableMapOf<Char, Int>()
            val first = inputPair.first.replace("[^\\w]".toRegex(), "").toLowerCase()
            val second = inputPair.second.replace("[^\\w]".toRegex(), "").toLowerCase()

            first.forEach { char -> lookUp[char] = lookUp[char]?.plus(1) ?: 1 }

            second.forEach forLoop@{ char ->
                if (!lookUp.containsKey(char)) return@forLoop
                else lookUp[char] = lookUp[char]!! - 1
            }

            val anagram = !lookUp.any { it.value > 0 || it.value < 0 }

            assert(anagram) { "$inputPair not Anagram" }
        }
    }

    @Test
    fun `Find out if 2 numbers have same numbers of digits`() {
        var firstNumber = 12345
        var secondNumber = 54321

        val firstFrequencyCounter = mutableMapOf<Int, Int>()
        while (firstNumber > 0) {
            val remainder = firstNumber % 10
            firstFrequencyCounter[remainder] = firstFrequencyCounter[remainder]?.plus(1) ?: 1
            firstNumber /= 10
        }

        while (secondNumber > 0) {
            val remainder = secondNumber % 10
            if (!firstFrequencyCounter.containsKey(remainder)) break

            firstFrequencyCounter[remainder] = firstFrequencyCounter[remainder]!! - 1
            secondNumber /= 10
        }

        val frequenciesSame = !firstFrequencyCounter.any { it.value > 0 || it.value < 0 }

        assert(frequenciesSame) { "Frequencies not same" }
    }

    @Test
    fun `Are there duplicates?`() {
        listOf(
            Pair(intArrayOf(1, 2, 3, 4, 4, 5), true),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6), false),
            Pair(intArrayOf(1, 222, 333, 34, 44, 99999, 2), false)
        ).forEach { inputPair ->
            val input = inputPair.first
            val expectedResult = inputPair.second

            val frequencyCounter = mutableMapOf<Int, Int>()
            for (counter in input.indices) {
                frequencyCounter[input[counter]] = frequencyCounter[input[counter]]?.plus(1) ?: 1
            }

            assert(frequencyCounter.any { it.value > 1 } == expectedResult)
            { "Expected Duplicates found to be $expectedResult for ${input.joinToString(",")}" }
        }
    }

}