package abc.abc268

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, m) = sc.nextLine().split(" ").map { it.toInt() }
        val s = Array(n) { sc.nextLine() }
        val t = mutableSetOf<String>()
        repeat(m) {
            val ts = sc.nextLine()
            t.add(ts)
        }

        // 使用できる余分なアンダースコア数
        var maxUnder = 16 - (n-1)
        repeat(n) { i -> maxUnder -= s[i].length }

        val used = BooleanArray(n)
        var ans = "-1"

        fun dfs(usedCnt: Int, res: String, remainUnder: Int): Boolean {
            if (usedCnt == n) {
                val result = res.dropLast(1)
                if (result.length < 3) return false
                if (t.contains(result)) return false

                ans = result
                return true
            }
            if (remainUnder > 0) {
                dfs(usedCnt, res + "_", remainUnder-1)
            }

            repeat(n) { j ->
                if (used[j]) return@repeat

                used[j] = true
                if (dfs(usedCnt+1, res + s[j] + "_", remainUnder)) return true
                used[j] = false
            }
            return false
        }

        PrintWriter(System.out).use { out ->
            repeat(n) { i ->
                used[i] = true
                if (dfs(1, s[i] + "_", maxUnder)) {
                    out.println(ans)
                    return
                }
                used[i] = false
            }
            out.println(ans)
        }
    }
}
