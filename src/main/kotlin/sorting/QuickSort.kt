package sorting

object QuickSort {

    fun sort(array: IntArray): IntArray {
        return quickSort(array)
    }

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

    private fun swap(array: IntArray, swapElement1Index: Int, swapElement2Index: Int): IntArray {
        val temp = array[swapElement1Index]
        array[swapElement1Index] = array[swapElement2Index]
        array[swapElement2Index] = temp
        return array
    }

}