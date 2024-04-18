package abc.abc332
import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val (h, w) = sc.nextLine().split(" ").map { it.toInt() }

        val a = List(h) { List(w) { sc.nextInt() } }
        val b = List(h) { List(w) { sc.nextInt() } }

        val dist = mutableMapOf<List<List<Int>>, Int>()
        val queue = ArrayDeque<List<List<Int>>>()
        fun push(state: List<List<Int>>, cost: Int) {
            if (dist.containsKey(state)) return

            dist[state] = cost
            queue.add(state)
        }
        // 初期状態プッシュ
        push(a, 0)

        // BFS
        while(queue.isNotEmpty()) {
            val currentState = queue.removeFirst()
            val currentCost = dist[currentState]!!

            // 行のスワップ
            repeat(h-1) { i ->
                val copy  = List(h) { ai -> currentState[ai].toList() }
                Collections.swap(copy, i, i+1)
                push(copy, currentCost+1)
            }

            // 列のスワップ
            repeat(w-1) { wi ->
                val copy = List(h) { ai -> currentState[ai].toMutableList()  }
                repeat(h) { hi ->
                    copy[hi][wi] = currentState[hi][wi+1]
                    copy[hi][wi+1] = currentState[hi][wi]
                }
                push(copy, currentCost+1)
            }
        }

        PrintWriter(System.out).use { out ->
            val ans = if (dist.containsKey(b)) dist[b] else -1
            out.println(ans)
        }
    }
}
