package abc.abc271

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, q) = sc.nextLine().split(" ").map { it.toInt() }

        val a = Array(n) {
            val l = sc.nextInt()
            IntArray(l) { sc.nextInt() }
        }

        PrintWriter(System.out).use { out ->
            repeat(q) {
                var s = sc.nextInt()
                var t = sc.nextInt()
                s--; t--;

                out.println(a[s][t])
            }
        }
    }
}
