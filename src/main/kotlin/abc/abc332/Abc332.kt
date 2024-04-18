package abc.abc332
import java.io.PrintWriter
import java.util.*

data class Grid(
    val data: List<IntArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Grid

        return data == other.data
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }
}

fun main() {
    Scanner(System.`in`).use { sc ->
        val (h, w) = sc.nextLine().split(" ").map { it.toInt() }

        val a = Grid(List(h) { IntArray(w) { sc.nextInt() } })
        val b = Grid(List(h) { IntArray(w) { sc.nextInt() } })

        val dist = mutableMapOf<Grid, Int>()
        val queue = ArrayDeque<Grid>()
        fun push(state: Grid, cost: Int) {
            if (dist.containsKey(state)) return

            dist[state] = cost
            queue.push(state)
        }
        // 初期状態プッシュ
        push(a, 0)
        val hashA = a.hashCode()
        val copyA  = Grid(List(h) { ai -> a.data[ai].copyOf()  })
        val copyHash = copyA.hashCode()
        push(copyA, 0)

        // BFS
//        while(queue.isNotEmpty()) {
//            val currentState = queue.first
//            val currentCost = dist[currentState]!!
//            queue.removeFirst()
//
//            // 行のスワップ
//            repeat(h-1) { i ->
//                val copyA  = List(h) { ai -> a[ai].copyOf()  }
//                Collections.swap(copyA, i, i+1)
//                push(copyA, currentCost+1)
//            }
//
//            // 列のスワップ
//            repeat(w-1) { wi ->
//                val copyA  = List(h) { ai -> a[ai].copyOf()  }
//                repeat(h) { hi ->
//                    copyA[hi][wi] = a[hi][wi+1]
//                    copyA[hi][wi+1] = a[hi][wi]
//                }
//                push(copyA, currentCost+1)
//            }
//        }
//
//        PrintWriter(System.out).use { out ->
//            val ans = if (dist.containsKey(b)) dist[b] else -1
//            out.println(ans)
//        }
    }
}
