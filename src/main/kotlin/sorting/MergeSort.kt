package sorting

object MergeSort {

    /***
     *           [8, 3, 5, 4, 7, 6, 1, 2]
     *         [8, 3, 5, 4]       [7, 6, 1, 2]
     *     [8, 3]     [5, 4]    [7, 6]     [1. 2]
     *    [8] [3]     [5] [4]  [7] [6]    [1] [2]
     *     [3, 8]     [4, 5]    [6, 7]    [1, 2]
     *     [3, 4, 5, 8]            [1, 2, 6, 7]
     *         [1, 2, 3, 4, 5, 6, 7, 8]
     */
    fun sort(array: IntArray): IntArray {
        if (array.size == 1) return array
        val midPoint = array.size / 2
        val left = sort(array.slice(0 until midPoint).toIntArray())
        val right = sort(array.slice(midPoint until array.size).toIntArray())
        return merge(left, right)
    }

    private fun merge(array1: IntArray, array2: IntArray): IntArray {
        var results = intArrayOf()
        var array1Counter = 0
        var array2Counter = 0

        while (array1Counter < array1.size && array2Counter < array2.size) {
            if (array2[array2Counter] > array1[array1Counter]) {
                results = results.plus(array1[array1Counter])
                array1Counter++
            } else {
                results = results.plus(array2[array2Counter])
                array2Counter++
            }
        }

        while (array1Counter < array1.size) {
            results = results.plus(array1[array1Counter])
            array1Counter++
        }

        while (array2Counter < array2.size) {
            results = results.plus(array2[array2Counter])
            array2Counter++
        }

        return results
    }

}