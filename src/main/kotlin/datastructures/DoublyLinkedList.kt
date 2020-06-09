package datastructures

class DoublyLinkedList {
    private data class Node(var value: Any, var prev: Node? = null, var next: Node? = null)

    private var head: Node? = null
    private var tail: Node? = null
    private var length = 0

    fun size(): Int {
        return length
    }

    fun push(value: Any) {
        val node = Node(value)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.prev = tail
            tail = node
        }
        length++
    }

    fun pop(): Any {
        if (head == null) throw error("No Items found in the LinkedList")

        val currentTail = tail

        if (length == 1) {
            head = null
            tail = null
        } else {
            tail = currentTail?.prev
            tail?.next = null
            currentTail?.prev = null
        }

        length--
        return currentTail?.value ?: throw error("Value is null")
    }

    fun shift(): Any {
        if (length == 0) throw error("No Items found in the LinkedList")
        val currentHead = head

        if (length == 1) {
            head = null
            tail = null
        } else {
            head = currentHead?.next
            head?.prev = null
            currentHead?.next = null
        }

        length--
        return currentHead?.value ?: throw error("Value is null")
    }

    fun unShift(value: Any) {
        val node = Node(value)
        if (length == 0) {
            head = node
            tail = node
        } else {
            val currentHead = head
            head = node
            head?.next = currentHead
            currentHead?.prev = node
        }

        length++
    }

    fun get(index: Int): Any {
        return getNode(index).value
    }

    fun set(index: Int, value: Any) {
        val node = getNode(index)
        node.value = value
    }

    fun insert(index: Int, value: Any) {
        if (index == 0 || length == 0) {
            unShift(value)
            return
        }

        if (index == length) {
            push(value)
            return
        }

        val newNode = Node(value)
        val beforeNode = getNode(index - 1)
        val afterNode = beforeNode.next
        beforeNode.next = newNode
        newNode.prev = beforeNode
        newNode.next = afterNode
        afterNode?.prev = newNode
        length++
    }

    fun remove(index: Int): Any {
        if (length == 0 || index > length) throw IndexOutOfBoundsException()

        if (index == 0) return shift()
        if (index == length - 1 || length == 0) return pop()

        val beforeNode = getNode(index - 1)
        val nodeToBeRemoved = beforeNode.next
        val afterNode = nodeToBeRemoved?.next
        beforeNode.next = afterNode
        afterNode?.prev = beforeNode

        nodeToBeRemoved?.next = null
        nodeToBeRemoved?.prev = null
        length--

        return nodeToBeRemoved?.value ?: throw error("Value is null")
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
        var current = head
        for (counter in 0 until length) {
            println(current?.value)
            current = current?.next
        }
    }

    fun midPoint(): Any {
        var fast = head
        var slow = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow?.value ?: throw error("Value is null")
    }

    private fun getNode(index: Int): Node {
        if (length == 0 || index > length) throw IndexOutOfBoundsException()
        var count: Int
        var current: Node?

        if (index <= length / 2) {
            current = head
            count = 0
            while (count != index) {
                current = current?.next
                count++
            }
        } else {
            current = tail
            count = length - 1
            while (count != index) {
                current = tail?.prev
                count--
            }
        }

        return current ?: throw error("Node at $index is null")
    }

}