package abc.abc273
import java.util.*
import kotlin.Comparator


class Abc273C {
    fun solve() {
        Scanner(System.`in`).use { sc ->
            val n = sc.nextLine().toInt()
            val a = IntArray(n)
            repeat(n) { i -> a[i] = sc.nextInt() }

            // 配列aの要素分布を逆順にする
            val cntMap = mutableMapOf<Int, Int>()
            a.forEach { v -> cntMap[v] = cntMap[v]?.let { it + 1 } ?: 1 }
            val cntMapList: List<Pair<Int, Int>> = cntMap.toSortedMap(Comparator.reverseOrder()).toList()

            repeat(n) { i ->
                val ans = if (i <= cntMapList.size-1) { cntMapList[i].second } else { 0 }
                println(ans)
            }
        }
    }
}

fun main() {
    Abc273C().solve()
}
