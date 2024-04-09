package abc.abc274

import java.util.*

class Abc274C {
    private val memo = mutableMapOf<Int, Int>()

    private fun f(x: Int): Int {
        if (x == 1) return 0

        if (memo.containsKey(x)) return memo[x]!!

        memo[x] = f(x/2)+1
        return memo[x]!!
    }

    fun solve() {
        val n: Int
        val a: IntArray
        Scanner(System.`in`).use { sc ->
            n = sc.nextInt()
            a = IntArray(n)
            repeat(n) { i -> a[i] = sc.nextInt() }
        }

        println("${f(1)}")
        repeat(n) { i ->
            val a1 = a[i] * 2
            val a2 = a1 + 1

            println("${f(a1)}")
            println("${f(a2)}")
        }
    }
}

fun main() {
    Abc274C().solve()
}
