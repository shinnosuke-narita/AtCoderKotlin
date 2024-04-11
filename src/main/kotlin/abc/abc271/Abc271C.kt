package abc.abc271

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val a = IntArray(n) { sc.nextInt() }
        a.sort()

        val set = mutableSetOf<Int>()
        a.forEach { set.add(it) }

        var cost = 0
        var nextNumber = 0
        while(true) {
            if (set.contains(nextNumber + 1)) cost++ else cost += 2

            if (cost > n) break
            nextNumber++
        }

        PrintWriter(System.out).use { out ->
            out.println(nextNumber)
        }
    }
}
