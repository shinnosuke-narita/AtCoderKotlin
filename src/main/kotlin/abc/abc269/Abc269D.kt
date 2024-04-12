package abc.abc269

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val xy = Array(n) { Pair(sc.nextInt(), sc.nextInt()) }

        val dist = mutableMapOf<Pair<Int, Int>, Boolean>()
        xy.forEach {  pos -> dist[pos] = false }
        val dx = intArrayOf(1, 1, 0, -1, -1, 0)
        val dy = intArrayOf(1, 0, -1, -1, 0, 1)

        fun dfs(current: Pair<Int, Int>) {
            if (dist[current]!!) return

            dist[current] = true
            repeat(dx.size) { di ->
                val nx = current.first + dx[di]
                val ny = current.second + dy[di]
                val nextPos = Pair(nx, ny)
                if (dist.containsKey(nextPos)) dfs(nextPos)
            }
        }

        var ans = 0
        repeat(n) { ni ->
            val pos = xy[ni]
            if (!dist[pos]!!) {
                dfs(pos)
                ans++
            }
        }

        PrintWriter(System.out).use { out ->
            out.println(ans)
        }
    }
}
