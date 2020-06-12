import datastructures.Queue
import datastructures.QueueUsingStack
import datastructures.Stack
import org.junit.jupiter.api.Test

class StacksAndQueuesTests {

    @Test
    fun `validate stack`() {
        val stack = Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)

        assert(stack.size() == 5)
        assert(stack.peek() == 5)
        assert(stack.pop() == 5)
        assert(stack.pop() == 4)
        assert(stack.pop() == 3)
        assert(stack.peek() == 2)
        assert(stack.pop() == 2)
        assert(stack.size() == 1)
    }

    @Test
    fun `validate queue`() {
        val queue = Queue()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)

        assert(queue.size() == 5)
        assert(queue.peek() == 1)
        assert(queue.dequeue() == 1)
        assert(queue.dequeue() == 2)
        assert(queue.dequeue() == 3)
        assert(queue.peek() == 4)
        assert(queue.dequeue() == 4)
        assert(queue.size() == 1)
    }

    @Test
    fun `validate queue implemented with stacks`() {
        val queue = QueueUsingStack()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)

        assert(queue.size() == 5)
        assert(queue.peek() == 1)
        assert(queue.dequeue() == 1)
        assert(queue.dequeue() == 2)
        assert(queue.dequeue() == 3)
        assert(queue.peek() == 4)
        assert(queue.dequeue() == 4)
        assert(queue.size() == 1)
    }

}