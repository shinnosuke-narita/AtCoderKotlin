package abc.abc274

import java.util.*

class Abc274C {

    fun solve() {
        val n: Int
        val a: IntArray
        Scanner(System.`in`).use { sc ->
            n = sc.nextInt()
            a = IntArray(n)
            repeat(n) { i -> a[i] = sc.nextInt() }

            val m = 2*n+2
            val ans = IntArray(m) {0}
            for (i in 1..n) {
                val parent = a[i-1]
                ans[i*2] = ans[parent]+1
                ans[i*2+1] = ans[parent]+1
            }

            repeat(m) {i ->
                if (i == 0) return@repeat
                println("${ans[i]}")
            }
        }
    }
}

fun main() {
    Abc274C().solve()
}
