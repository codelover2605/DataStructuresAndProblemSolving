package sorting

object BubbleSort {

    /**
     * Start Looping from beginning until end of array
     * Start inner Loop from beginning until array size minus 1
     * If array of inner loop value is greater than outer loop, swap them
     * Repeat until array is sorted
     */
    fun sort(array: IntArray): IntArray {
        for (counter in array.indices) {
            var noSwaps = true
            for (innerCounter in 0 until array.size - 1) {
                if (array[innerCounter] > array[innerCounter + 1]) {
                    val temp = array[innerCounter]
                    array[innerCounter] = array[innerCounter + 1]
                    array[innerCounter + 1] = temp
                    noSwaps = false
                }
            }
            if (noSwaps) break
        }

        return array
    }

}