package bootcamp

import org.junit.jupiter.api.Test


class IterationsProblems {

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
        assert(sum == 55 ) {"Expected 55 But was: $sum"}
    }

}