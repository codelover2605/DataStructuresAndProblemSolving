import org.junit.jupiter.api.Test
import sorting.BubbleSort
import sorting.InsertionSort
import sorting.SelectionSort

class Sorting {

    @Test
    fun `Validate Bubble Sort`() {
        val array = intArrayOf(10, 3, 4, 5, 6, 2, 1)
        val sortedArray = BubbleSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) {"Expected: $array But was: $sortedArray"}
    }

    @Test
    fun `Validate Selection Sort`() {
        val array = intArrayOf(10, 3, 4, 5, 6, 2, 1)
        val sortedArray = SelectionSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) {"Expected: $array But was: $sortedArray"}
    }

    @Test
    fun `Validate Insertion Sort`() {
        val array = intArrayOf(10, 3, 4, 5, 6, 2, 1)
        val sortedArray = InsertionSort.sort(array)
        array.sort()
        assert(sortedArray.contentEquals(array)) {"Expected: $array But was: $sortedArray"}
    }

}