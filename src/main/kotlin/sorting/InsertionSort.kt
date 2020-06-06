package sorting

object InsertionSort {

    /**
     * Start by picking the second element in the array
     * Compare the second element with the one before it, swap if necessary
     * Continue to the next element, if it's in incorrect order,
     * iterate through sorted portion to place element in correct place
     */
    fun sort(array: IntArray): IntArray {
        for (counter in 1 until array.size) {
            val currentVal = array[counter]
            var j = counter - 1
            while (j >= 0 && array[j] > currentVal) {
                array[j + 1] = array[j]
                j--
            }

            array[j + 1] = currentVal
        }

        return array
    }

}