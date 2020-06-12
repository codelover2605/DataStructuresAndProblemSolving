package datastructures

class QueueUsingStack {

    private val data: Stack = Stack()

    fun enqueue(value: Any) {
        data.push(value)
    }

    fun dequeue() : Any {
        val stack = Stack()
        while(data.size() != 0) {
            stack.push(data.pop())
        }

        val itemToBePopped = stack.pop()
        while(stack.size() != 0) {
            data.push(stack.pop())
        }

        return itemToBePopped
    }

    fun peek(): Any {
        val stack = Stack()
        while(data.size() != 0) {
            stack.push(data.pop())
        }

        val itemToBePeeked = stack.peek()
        while(stack.size() != 0) {
            data.push(stack.pop())
        }

        return itemToBePeeked
    }

    fun size(): Int {
        return data.size()
    }

}