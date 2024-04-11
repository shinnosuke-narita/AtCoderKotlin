package abc.abc270

import java.io.PrintWriter
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    Scanner(System.`in`).use { sc ->
        var (n, start, goal) = sc.nextLine().split(" ").map { it.toInt() }
        start--; goal--
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        repeat(n-1) {
            var (u, v) = sc.nextLine().split(" ").map { it.toInt() }
            u--; v--
            graph[u].add(v)
            graph[v].add(u)
        }

        // DFS
        val seen = BooleanArray(n) {false}
        val deque = ArrayDeque<Int>()
        fun dfs(v: Int): Boolean {
            if (seen[v]) return false

            seen[v] = true
            deque.add(v)
            if (v == goal) {
                return true
            }
            for (u in graph[v]) {
                if (dfs(u)) return true
            }
            deque.removeLast()
            return false
        }
        dfs(start)

        PrintWriter(System.out).use { out ->
            while(deque.isNotEmpty()) {
                val ans = deque.removeFirst() + 1
                out.print("$ans ")
            }
            out.println()
        }
    }
}
