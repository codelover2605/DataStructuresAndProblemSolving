package datastructures

class Queue {
    private data class Node(var value: Any, var next: Node? = null)

    private var first: Node? = null
    private var last: Node? = null
    private var length: Int = 0

    fun enqueue(value: Any) {
        val newNode = Node(value)
        if (first == null) {
            first = newNode
            last = newNode
        } else {
            last?.next = newNode
            last = newNode
        }

        length++
    }

    fun dequeue(): Any {
        if (length == 0) throw error("No Items in the Queue")

        val temp = first
        if (length == 1) last == null
        first = first?.next
        length--
        return temp?.value ?: throw error("Value is null")
    }

    fun peek(): Any {
        if(length == 0) throw error("No items in the queue")

        return first?.value ?: throw error("Value is null")
    }

    fun size() = length
}