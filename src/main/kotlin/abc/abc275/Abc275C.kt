package abc.abc275
import java.util.Scanner

typealias P = Pair<Int, Int>

class Abc275C {
    companion object {
        private const val N = 9
    }
    fun solve() {
        val s = Array(N) {""}
        Scanner(System.`in`).use { sc ->
            repeat(N){  i->
                s[i] = sc.nextLine()
            }
        }

        // ポーンの座標を保持
        val pornPos = arrayListOf<P>()
        val pornSet = mutableSetOf<P>()
        repeat(N) { i ->
            repeat(N) { j ->
                if (s[i][j] == '#') {
                    val p  = Pair(i, j)
                    pornPos.add(p)
                    pornSet.add(p)
                }
            }
        }

        var ans = 0L
        for(a in pornPos) {
            for (b in pornPos) {
                if (a == b) continue

                val xi = b.first - a.first
                val xj = b.second - a.second
                val ci = b.first - xj
                val cj = b.second + xi
                val di = ci - xi
                val dj = cj - xj
                if (pornSet.contains(Pair(ci, cj))
                    && pornSet.contains(Pair(di, dj))) {
                    ans++
                }
            }
        }

        ans /= 4
        println(ans)
    }
}

fun main() {
    Abc275C().solve()
}
