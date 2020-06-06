import org.junit.jupiter.api.Test


class Recursion {

    /**
     * Sum upto n:    1     2   ...... (n-1) n
     * Sum upto n:    n   (n-1) ......   2   1
     * 2sum upto n: (n+1) (n+1) ...... (n+1) (n+1)
     * sumUpto n = n * (n + 1) / 2
     */
    @Test
    fun `Sum of All Numbers from 1 upto n`() {
        val n = 10
        val sum = n * (n + 1) / 2
        assert(sum == 55) { "Expected 55 But was: $sum" }
    }

    @Test
    fun `Sum of All Numbers from 1 upto n - Recursive Solution`() {
        val n = 10
        val sum = sumRange(n)
        assert(sum == 55) { "Expected 55 But was: $sum" }
    }

    @Test
    fun factorial() {
        val n = 10
        val factorial = factorial(n)
        println(factorial)
    }

    private fun factorial(n: Int): Int {
        if(n == 1) return 1
        return n * factorial(n - 1)
    }

    private fun sumRange(n: Int): Int {
        if (n == 0) return 0
        return n + sumRange(n - 1)
    }

}