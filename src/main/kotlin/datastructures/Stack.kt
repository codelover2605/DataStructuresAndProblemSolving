package datastructures

class Stack {
    private data class Node(var value: Any, var next: Node? = null)

    private var first: Node? = null
    private var last: Node? = null
    private var length: Int = 0

    fun push(value: Any) {
        val newNode = Node(value)
        if (first == null) {
            first = newNode
            last = newNode
        } else {
            val temp = first
            first = newNode
            first?.next = temp
        }
        length++
    }

    fun pop(): Any {
        if (length == 0) throw error("No Items in the stack")

        val current = first
        if (length == 1) {
            first = null
            last = null
        } else{
            first = current?.next
            current?.next = null
        }

        length--
        return current?.value ?: throw error("Value is null")
    }

    fun peek(): Any {
        if(length == 0) throw error("No Items in the stack")
        return first?.value ?: throw error("Value is null")
    }

    fun size() = length

}