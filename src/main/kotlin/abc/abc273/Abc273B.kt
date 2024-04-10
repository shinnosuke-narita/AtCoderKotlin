package abc.abc273

import java.util.*

class Abc273B {
    fun solve() {
        Scanner(System.`in`).use { sc ->
            var x: Long = sc.nextLong()
            val k: Int = sc.nextInt()

            var t = 1L
            repeat(k) {
                val d = x / t % 10

                t *= 10L
                x = x / t * t
                if (d >= 5) x += t
            }
            println(x)
        }
    }
}

fun main() {
    Abc273B().solve()
}
