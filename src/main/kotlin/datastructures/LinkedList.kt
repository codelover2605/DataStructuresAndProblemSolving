package datastructures

data class Node(var value: Any, var next: Node? = null)

class LinkedList {

    private var head: Node?
    private var tail: Node?
    private var length: Int = 0

    init {
        head = null
        tail = null
    }

    fun size(): Int {
        return length
    }

    fun push(value: Any): LinkedList {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        length++
        return this
    }

    fun pop(): Any {
        var current = head
        var newTail = current

        while (current?.next != null) {
            newTail = current
            current = current.next
        }

        tail = newTail
        newTail?.next = null
        length--

        if (length == 0) {
            head = null
            tail = null
        }

        return current?.value ?: error("Value is null")
    }

    fun shift(): Any {
        if (head == null) throw error("No nodes present")

        val currentHead = head
        head = currentHead?.next
        length--

        if (length == 0) {
            this.tail = null
        }

        return currentHead?.value ?: throw error("Value is null")
    }

    fun unShift(value: Any) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            val currentHead = head
            head = newNode
            head?.next = currentHead
        }

        length++
    }

    fun get(index: Int): Any {
        return getNode(index).value
    }

    fun set(index: Int, value: Any) {
        getNode(index).value = value
    }

    fun insert(index: Int, value: Any) {
        val newNode = Node(value)
        if (index == 0) unShift(value)
        if (index == length - 1) push(value)
        else {
            val previousNode = getNode(index - 1)
            val currentNode = previousNode.next
            newNode.next = currentNode
            previousNode.next = newNode
            length++
        }
    }

    fun remove(index: Int): Any {
        if (index == 1) return shift()
        return if (index == length - 1) pop()
        else {
            val previousNode = getNode(index - 1)
            val nodeToBeRemoved = previousNode.next
            previousNode.next = nodeToBeRemoved?.next
            length--
            nodeToBeRemoved?.value ?: throw error("Value is null")
        }
    }

    fun reverse() {
        if (length == 0) return

        var node = head
        head = tail
        tail = node

        var next: Node?
        var previous: Node? = null

        for (counter in 0 until length) {
            next = node?.next
            node?.next = previous
            previous = node
            node = next
        }
    }

    fun print() {
        if (length < 0) throw IndexOutOfBoundsException()
        var current = head

        while (current?.next != null) {
            println(current.value)
            current = current.next
        }

        println(current?.value)
    }

    fun nthValueFromLast(n: Int) : Any{
        var slow = head
        var fast = head
        var count = n

        while (count > 0) {
            fast = fast?.next
            count--
        }

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next
        }

        return slow?.value ?: throw error("Value is null")
    }

    fun midPoint(): Any {
        var slow = head
        var fast = head

        while(fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow?.value ?: throw error("Value is null")
    }

    private fun getNode(index: Int): Node {
        if (index < 0 || index > length) throw IndexOutOfBoundsException()

        var counter = 0
        var current = head

        while (counter != index) {
            counter++
            current = current?.next
        }

        return current ?: throw error("Node is Null")
    }

}