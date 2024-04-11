package abc.abc272

import java.io.PrintWriter
import java.util.*

import kotlin.collections.ArrayDeque

private const val INF = 1001001

fun main() {
    Scanner(System.`in`).use { sc ->
        val (n, m) = sc.nextLine().split(" ").map { it.toInt() }

        // 距離Mの座標を全列挙
        val posList = mutableListOf<Pair<Int, Int>>()
        for (i in -n..n) {
            for (j in -n..n) {
                val distance = i*i+j*j
                if (distance == m) { posList.add(Pair(i, j)) }
            }
        }

        // BFS
        val que = ArrayDeque<Pair<Int, Int>>()
        val dist = Array(n) { IntArray(n) { INF } }
        que.add(Pair(0, 0))
        dist[0][0] = 0

        val push = { current: Pair<Int, Int>, cost: Int ->
            for (pos in  posList) {
                val nextI = current.first+pos.first
                val nextJ = current.second+pos.second
                if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n) { continue }
                if (dist[nextI][nextJ] != INF) continue

                dist[nextI][nextJ] = cost+1
                que.add(Pair(nextI, nextJ))
            }
        }

        while(que.isNotEmpty()) {
            val pos = que.removeFirst()
            push(pos, dist[pos.first][pos.second])
        }

        PrintWriter(System.out).use { out ->
            repeat(n) { i ->
                repeat(n) { j ->
                    if (dist[i][j] == INF) out.print("-1 ")
                    else out.print("${dist[i][j]} ")
                }
                out.println()
            }
        }
    }
}
