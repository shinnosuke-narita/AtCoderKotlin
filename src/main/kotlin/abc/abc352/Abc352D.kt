package abc.abc352

import java.io.PrintWriter
import java.util.*
import kotlin.math.min

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, k) = sc.nextLine().split(" ").map { it.toInt() }
        val p = sc.nextLine().split(" ").map { it.toInt() - 1 }

        val q = IntArray(n)
        repeat(n) { q[p[it]] = it }

        val st = sortedSetOf<Int>()
        var ans = n
        repeat(n) { i ->
            st.add(q[i])
            if (st.size > k) st.remove(q[i-k])
            if (st.size == k) {
                val now = st.last() - st.first()
                ans = min(ans, now)
            }
        }

        PrintWriter(System.out).use { out ->
            out.println(ans)
        }
    }
}
