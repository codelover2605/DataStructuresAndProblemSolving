package sorting

object QuickSort {

    fun sort(array: IntArray): IntArray {
        return quickSort(array)
    }

    /**
     * Call the Pivot on the array
     * Recursively call the pivot helper on the sub array to the left of the pivot index,
     * and sub array to the right of the pivotIndex
     */
    private fun quickSort(array: IntArray, left: Int = 0, right: Int = array.size - 1): IntArray {
        if (left < right) {
            val pivotIndex = pivot(array, left, right)
            //left
            quickSort(array, left, pivotIndex - 1)

            //right
            quickSort(array, pivotIndex + 1, right)
        }

        return array
    }

    /***
     * Initialize the pivot from the start of the array
     * Store the current PivotIndex
     * Loop through Array from start until end
     * If pivot is greater than current element, increment PivotIndex and swap current element with element at Pivot Index
     * Once the iteration ends, swap the starting element with pivot index
     */
    private fun pivot(array: IntArray, start: Int = 0, end: Int = array.size - 1): Int {
        var inputArray = array
        val pivot = array[start]
        var swapIndex = start

        for (counter in start + 1 until end) {
            if (pivot > array[counter]) {
                swapIndex++
                inputArray = swap(array, swapIndex, counter)
            }
        }

        swap(inputArray, start, swapIndex)
        return swapIndex
    }

    /**
     * Swap the elements with the indices specified
     */
    private fun swap(array: IntArray, swapElement1Index: Int, swapElement2Index: Int): IntArray {
        val temp = array[swapElement1Index]
        array[swapElement1Index] = array[swapElement2Index]
        array[swapElement2Index] = temp
        return array
    }

}