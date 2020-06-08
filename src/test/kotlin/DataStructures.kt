import datastructures.LinkedList
import org.junit.jupiter.api.Test

class DataStructures {

    @Test
    fun `validate Push And Pop`() {
        val linkedList = LinkedList()
        linkedList.push("Hello")
        linkedList.push("there!")
        assert(linkedList.pop() == "there!")
        assert(linkedList.pop() == "Hello")
    }

    @Test
    fun `validate Shift And Unshift`() {
        val linkedList = LinkedList()
        linkedList.push("Hello")
        linkedList.push("there!")
        assert(linkedList.shift() == "Hello")
        assert(linkedList.size() == 1)

        linkedList.unShift("Hi")
        assert(linkedList.size() == 2)
        assert(linkedList.pop() == "there!")
        assert(linkedList.pop() == "Hi")
    }

    @Test
    fun `validate get and set`() {
        val linkedList = LinkedList()
        linkedList.push("Hi")
        linkedList.push("there!")
        linkedList.push("Kotlin")
        linkedList.push("is")
        linkedList.push("Amazing!")
        assert(linkedList.get(2) == "Kotlin")
        assert(linkedList.get(4) == "Amazing!")

        linkedList.set(0, "Hello")
        linkedList.set(1, "World!")
        assert(linkedList.get(0) == "Hello")
        assert(linkedList.get(1) == "World!")
    }

    @Test
    fun `validate insert and remove`() {
        val linkedList = LinkedList()
        linkedList.push("Hi")
        linkedList.push("there!")
        linkedList.push("Kotlin")
        linkedList.push("is")
        linkedList.push("Amazing!")
        assert(linkedList.size() == 5)
        linkedList.insert(2, "What's up?")
        assert(linkedList.size() == 6)
        assert(linkedList.get(2) == "What's up?")
        assert(linkedList.get(3) == "Kotlin")

        linkedList.remove(2)
        assert(linkedList.get(2) == "Kotlin")
        assert(linkedList.size() == 5)
    }

    @Test
    fun `validate reverse`() {
        val linkedList = LinkedList()
        linkedList.push("I am")
        linkedList.push("Yoda")
        linkedList.push("Kotlin")
        linkedList.push("is")
        linkedList.push("Amazing!")

        linkedList.reverse()
        println(linkedList.print())
    }

    @Test
    fun `Validate nth Value`() {
        val linkedList = LinkedList()
        linkedList.push(1)
        linkedList.push(2)
        linkedList.push(3)
        linkedList.push(4)
        linkedList.push(5)

        assert(linkedList.nthValueFromLast(1) == 4)
        assert(linkedList.nthValueFromLast(4) == 1)
    }

    @Test
    fun `Validate mid point`() {
        val linkedList = LinkedList()
        linkedList.push(1)
        linkedList.push(2)
        linkedList.push(3)
        linkedList.push(4)
        linkedList.push(5)

        assert(linkedList.midPoint() == 3)
    }

}