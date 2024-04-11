package abc.abc271

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, s) = sc.nextLine().split(" ").map { it.toInt() }
        val ab = Array(n) { Pair(sc.nextInt(), sc.nextInt()) }

        val dp = Array(n+1) { IntArray(s+1) { 0 } }
        dp[0][0] = 1
        for (i in 0 until n) {
            for (j in 0 until s+1) {
                if (dp[i][j] == 1) {
                    val (a, b) = ab[i]
                    if (j+a <= s) dp[i+1][j+a] = 1
                    if (j+b <= s) dp[i+1][j+b] = 1
                }
            }
        }

        PrintWriter(System.out).use { out ->
            if (dp[n][s] == 0) {
                out.println("No")
                return
            }

            // ok
            out.println("Yes")

            var ss = s
            var ans = ""
            val check = { i: Int, x: Int, value: Char ->
                if (ss - x >= 0 && dp[i][ss-x] == 1) {
                    ss -= x
                    ans += value
                    true
                } else {
                    false
                }
            }
            for(i in n-1 downTo 0) {
                val (a, b) = ab[i]
                if (check(i, a, 'H')) continue
                check(i, b, 'T')
            }

            out.println(ans.reversed())
        }
    }
}
