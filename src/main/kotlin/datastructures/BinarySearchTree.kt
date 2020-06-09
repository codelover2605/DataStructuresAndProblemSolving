package datastructures

import java.util.LinkedList

data class Node(var value: Int, var left: Node? = null, var right: Node? = null)

class BinarySearchTree {
    private var root: Node? = null

    fun insert(value: Int) {
        val newNode = Node(value)
        if (root == null) {
            root = newNode
            return
        }

        var current = root
        while (current != null) {
            if (value < current.value) {
                if (current.left == null) current.left = newNode
                else current = current.left
            } else if (value > current.value) {
                if (current.right == null) current.right = newNode
                else current = current.right
            } else return
        }
    }

    fun contains(value: Int): Boolean {
        if (root == null) return false

        var current = root
        var found = false

        while (current != null && !found) {
            when {
                value < current.value -> current = current.left
                value > current.value -> current = current.right
                else -> found = true
            }
        }

        return found
    }

    fun breadthFirstSearch(): IntArray {
        if (root == null) return intArrayOf()

        var node = root
        val queue = LinkedList<Node?>()
        queue.add(node)
        var data = intArrayOf()

        while (queue.size > 0) {
            node = queue.removeFirst()
            data = data.plus(node?.value!!)
            if (node.left != null) queue.add(node.left)
            if (node.right != null) queue.add(node.right)
        }

        return data
    }

    fun depthFirstSearchPreOrder(): IntArray {
        var data = intArrayOf()
        if (root == null) return data

        fun depthPreOrderTraverse(node: Node?) {
            data = data.plus(node?.value!!)
            if (node.left != null) depthPreOrderTraverse(node.left)
            if (node.right != null) depthPreOrderTraverse(node.right)
        }

        depthPreOrderTraverse(root)
        return data
    }

    fun depthFirstSearchPostOrder(): IntArray {
        var data = intArrayOf()
        if (root == null) return data

        fun traverse(node: Node?) {
            if (node?.left != null) traverse(node.left)
            if (node?.right != null) traverse(node.right)

            data = data.plus(node?.value!!)
        }

        traverse(root)
        return data
    }

    fun depthFirstSearchInOrder(): IntArray {
        var data = intArrayOf()
        if(root == null) return data

        fun traverse(node: Node?) {
            if(node?.left != null) traverse(node.left)
            data = data.plus(node?.value!!)
            if(node.right != null) traverse(node.right)
        }

        traverse(root)
        return data
    }
}