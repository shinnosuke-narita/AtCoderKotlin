package abc.abc269

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = 10
        val s = Array(n) { sc.nextLine() }

        var ai: Int = 0
        var cj: Int = 0
        for (i in 0 until  10) {
            var ok = false
            for (j in 0 until 10) {
                if (s[i][j] == '#') {
                    ai = i; cj = j
                    ok = true
                    break
                }
            }
            if (ok) break
        }

        var bi = ai
        var dj = cj
        for (i in ai until n-1) {
            if (s[bi+1][cj] != '#') break

            bi++
        }
        for (i in cj until n-1) {
            if (s[ai][dj+1] != '#') break

            dj++
        }

        PrintWriter(System.out).use { out ->
            out.printf("%d %d\n", ++ai, ++bi)
            out.printf("%d %d", ++cj, ++dj)
        }
    }
}
