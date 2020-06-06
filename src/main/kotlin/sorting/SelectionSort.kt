package sorting

object SelectionSort {

    /**
     * Store the first element as smallest value
     * Compare this to the next item until lowest is found
     * If smaller is found, designate smaller number to be the new minimum, continue until end of array
     * If minimum is not the value initially began, swap them
     * Repeat until array sorted
     */
    fun sort(array: IntArray): IntArray {
        for (counter in array.indices) {
            var lowest = counter
            for (innerCounter in 0 until array.size - 1) {
                if (array[innerCounter] < array[lowest])
                    lowest = innerCounter
            }

            val temp = array[counter]
            array[counter] = array[lowest]
            array[lowest] = temp
        }

        return array
    }

}