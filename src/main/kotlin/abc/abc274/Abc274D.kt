package abc.abc274

import java.util.*

class Abc274D {
    private lateinit var a: IntArray

    private fun addNewPos(i: Int, set: Set<Int>): MutableSet<Int> {
        val nSet = mutableSetOf<Int>()
        set.forEach { value ->
            nSet.add(value+a[i])
            nSet.add(value-a[i])
        }
        return nSet
    }

    fun solve() {
        Scanner(System.`in`).use { sc ->
            val (n, x, y) = sc.nextLine().split(" ").map { it.toInt() }
            a = IntArray(n)
            repeat(n) { i -> a[i] = sc.nextInt() }

            var xSet = mutableSetOf<Int>()
            var ySet = mutableSetOf<Int>()
            ySet.add(0)
            xSet.add(a[0])

            for (i in 1 until n) {
                if (i % 2 == 1) {
                    // y軸の移動
                    ySet = addNewPos(i, ySet)
                } else {
                    // x軸の移動
                    xSet = addNewPos(i, xSet)
                }
            }

            val ans = if (ySet.contains(y) && xSet.contains(x)) "Yes" else "No"
            println(ans)
        }
    }
}

fun main() {
    Abc274D().solve()
}
