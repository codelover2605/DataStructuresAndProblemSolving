import org.junit.jupiter.api.Test

class Others {

    @Test
    fun `Find the Mirror Pair`() {
        val inputArray = arrayOf(Pair(1, 3), Pair(4, 5), Pair(3, 9), Pair(2, 20), Pair(3, 1), Pair(4, 2), Pair(20, 2))
        val firstNumbers = mutableListOf<Int>()
        val secondNumbers = mutableListOf<Int>()
        val pairs = mutableListOf<Pair<Int, Int>>()

        inputArray.forEach { pair ->
            firstNumbers.add(pair.first)
            secondNumbers.add(pair.second)
        }

        for (counter in firstNumbers.indices) {
            val index = secondNumbers.indexOf(firstNumbers[counter])
            if (index == -1) continue
            if (firstNumbers[index] == secondNumbers[counter]) {
                pairs.add(inputArray[minOf(counter, index)])
                firstNumbers[index] = -1
                firstNumbers[counter] = -1
            }
        }

        assert(pairs == listOf(Pair(1,3), Pair(2, 20))) {"Expected: $pairs"}
    }

}
