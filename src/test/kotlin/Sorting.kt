import org.junit.jupiter.api.Test
import sorting.BubbleSort
import sorting.InsertionSort
import sorting.MergeSort
import sorting.SelectionSort

class Sorting {

    @Test
    fun `Validate Bubble Sort`() {
        var array = intArrayOf()
        (1..100000).forEach { _ ->
            array = array.plus((1 until 1000).random())
        }
        val sortedArray = BubbleSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) { "Expected: $array But was: $sortedArray" }
    }

    @Test
    fun `Validate Selection Sort`() {
        var array = intArrayOf()
        (1..100000).forEach { _ ->
            array = array.plus((1 until 1000).random())
        }
        val sortedArray = SelectionSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) { "Expected: $array But was: $sortedArray" }
    }

    @Test
    fun `Validate Insertion Sort`() {
        var array = intArrayOf()
        (1..100).forEach { _ ->
            array = array.plus((1 until 10000000).random())
        }
        val sortedArray = InsertionSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) { "Expected: $array But was: $sortedArray" }
    }

    @Test
    fun `Validate Merge Sort`() {
        var array = intArrayOf()
        (1..100).forEach { _ ->
            array = array.plus((1 until 10000000).random())
        }

        val sortedArray = MergeSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array))
        { "Expected: ${array.joinToString(",")} But was: ${sortedArray.joinToString(",")}" }
    }

}