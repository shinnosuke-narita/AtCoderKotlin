package abc.abc274
import java.util.Scanner

class Abc274B {
    fun solve() {
        val h: Int
        val w: Int
        val c: Array<String>

        Scanner(System.`in`).use { sc ->
            val (hh, ww) = sc.nextLine().split(" ").map { it.toInt() }
            h = hh
            w = ww
            c = Array(h) {""}
            repeat(h) { i ->
                val line = sc.nextLine()
                c[i] = line
            }
        }

        repeat(w) {j ->
            var cnt = 0
            repeat(h) { i ->
                if (c[i][j] == '#') cnt++
            }
            print("$cnt ")
        }
        println()
    }
}

fun main() {
    Abc274B().solve()
}
