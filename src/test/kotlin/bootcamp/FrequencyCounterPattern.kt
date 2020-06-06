package bootcamp

import org.junit.jupiter.api.Test

class FrequencyCounterPattern {

    /***
     * Time Complexity O(n)
     */
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

        var anagram = true

        inputPairs.forEach { inputPair ->
            val lookUp = mutableMapOf<Char, Int>()
            val first = inputPair.first.replace("[^\\w]".toRegex(), "").toLowerCase()
            val second = inputPair.second.replace("[^\\w]".toRegex(), "").toLowerCase()

            first.forEach { char -> lookUp[char] = lookUp[char]?.plus(1) ?: 1}

            second.forEach { char ->
                if(!lookUp.containsKey(char)) anagram = false
                else lookUp[char] = lookUp[char]!! - 1
            }

            assert(anagram) {"$inputPair not Anagram"}
        }
    }

}