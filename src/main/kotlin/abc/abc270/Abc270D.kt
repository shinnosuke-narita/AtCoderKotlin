package abc.abc270

import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, k) = sc.nextLine().split(" ").map { it.toInt() }
        val a = IntArray(k) { sc.nextInt() }

        val dp = IntArray(n+1) { -1 }
        dp[0] = 0
        fun dfs(current: Int): Int {
            if (current == 0) return 0

            if (dp[current] != -1) return dp[current]

            var res = 0
            for (aa in a) {
                if (current < aa) continue

                res = max(res, current - dfs(current - aa))
            }
            dp[current] = res

            return dp[current]
        }

        PrintWriter(System.out).use { out ->
            out.println(dfs(n))
        }
    }
}
