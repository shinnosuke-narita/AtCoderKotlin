package abc.abc257
import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextLine().toInt()
        val s = sc.nextLine()

        val w = IntArray(n) { sc.nextInt() }
        var mp = mutableMapOf<Int, MutableList<Int>>()
        repeat(n) { i ->
            mp[w[i]]?.add(i) ?: run { mp.put(w[i], mutableListOf(i)) }
        }
        mp = mp.toSortedMap()

        var ans: Int
        var now = 0
        s.forEach { if (it == '1') now++ }
        ans = now

        mp.forEach { (_, list) ->
            list.forEach { i ->
                if (s[i] == '1') now-- else now++
            }
            ans = max(ans, now)
        }

        PrintWriter(System.out).use { out ->
            out.println(ans)
        }
    }
}
