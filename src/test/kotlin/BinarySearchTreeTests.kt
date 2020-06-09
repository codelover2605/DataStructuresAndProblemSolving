import datastructures.BinarySearchTree
import org.junit.jupiter.api.Test

class BinarySearchTreeTests {

    @Test
    fun `validate insert`() {
        val tree = BinarySearchTree()
        tree.insert(10)
        tree.insert(5)
        tree.insert(13)
        tree.insert(11)
        tree.insert(2)
        tree.insert(16)
        tree.insert(7)

        assert(tree.contains(2))
        assert(tree.contains(11))
        assert(!tree.contains(23))
    }

    @Test
    fun `Breadth First Search`() {
        val tree = BinarySearchTree()
        tree.insert(10)
        tree.insert(15)
        tree.insert(6)
        tree.insert(20)
        tree.insert(3)
        tree.insert(8)

        val expectedArray = intArrayOf(10, 6, 15, 3, 8, 20)
        val data = tree.breadthFirstSearch()
        assert(data.contentEquals(expectedArray))
    }

    @Test
    fun `DepthFirstPreOrder Search`() {
        val tree = BinarySearchTree()
        tree.insert(10)
        tree.insert(15)
        tree.insert(6)
        tree.insert(20)
        tree.insert(3)
        tree.insert(8)

        val expectedArray = intArrayOf(10, 6, 3, 8, 15, 20)
        val data = tree.depthFirstSearchPreOrder()
        assert(data.contentEquals(expectedArray))
    }

    @Test
    fun `DepthFirstSearchPostOrder Search`() {
        val tree = BinarySearchTree()
        tree.insert(10)
        tree.insert(15)
        tree.insert(6)
        tree.insert(20)
        tree.insert(3)
        tree.insert(8)

        val expectedArray = intArrayOf(3, 8, 6, 20, 15, 10)
        val data = tree.depthFirstSearchPostOrder()
        assert(data.contentEquals(expectedArray))
    }

    @Test
    fun `DepthFirstSearchInOrder Search`() {
        val tree = BinarySearchTree()
        tree.insert(10)
        tree.insert(15)
        tree.insert(6)
        tree.insert(20)
        tree.insert(3)
        tree.insert(8)

        val expectedArray = intArrayOf(3, 6, 8, 10, 15, 20)
        val data = tree.depthFirstSearchInOrder()
        assert(data.contentEquals(expectedArray))
    }

}