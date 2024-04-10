package abc.abc273
import java.util.*
import kotlin.math.min

typealias MP = MutableMap<Int, MutableList<Int>>

class Abc273D {
    private fun init(mp: MP, end: Int) {
        mp.forEach { (_, list) ->
            list.sort()
            list.add(end)
        }
    }

    private fun lowerBound(list: List<Int>, value: Int): Int {
        var left = 0
        var right = list.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid] < value) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }

    private fun move(mp: MP, i: Int, j: Int, l: Int, end: Int): Int {
        if (!mp.containsKey(i)) {
            return min(j+l, end-1)
        }

        val walls = mp[i]!!
        val res = lowerBound(walls, j)
        return min(walls[res]-1, j+l)
    }

    fun solve() {
        Scanner(System.`in`).use { sc ->
            val (h, w, si, sj) = sc.nextLine().split(" ").map { it.toInt() }
            val n = sc.nextLine().toInt()

            /** 壁の座標を取得 */
            val mpR: MP = mutableMapOf()
            val mpL: MP = mutableMapOf()
            val mpD: MP = mutableMapOf()
            val mpU: MP = mutableMapOf()
            repeat(n) {
                val (i, j) = sc.nextLine().split(" ").map { it.toInt() }
                mpR[i]?.add(j) ?: run { mpR[i] = mutableListOf(j)  }
                mpL[i]?.add(-j) ?: run { mpL[i] = mutableListOf(-j) }
                mpD[j]?.add(i) ?: run { mpD[j] = mutableListOf(i) }
                mpU[j]?.add(-i) ?: run { mpU[j] = mutableListOf(-i) }
            }
            /** 壁の座標をソート */
            init(mpR, w+1)
            init(mpL, 0)
            init(mpD, h+1)
            init(mpU, 0)

            /** queryの処理 */
            val q = sc.nextLine().toInt()
            var i = si
            var j = sj
            repeat(q) {
                val dl = sc.nextLine().split(" ")
                val d = dl[0].toCharArray().first()
                val l = dl[1].toInt()

                if (d == 'R') j = move(mpR, i, j, l, w+1)
                if (d == 'L') j = -move(mpL, i, -j, l, 0)
                if (d == 'D') i = move(mpD, j, i, l, h+1)
                if (d == 'U') i = -move(mpU, j, -i, l, 0)

                val ans = String.format("%d %d", i, j)
                println(ans)
            }
        }
    }
}

fun main() {
    Abc273D().solve()
}
