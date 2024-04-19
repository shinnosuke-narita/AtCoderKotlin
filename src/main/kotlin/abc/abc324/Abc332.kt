package abc.abc324
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val t = sc.next()
        val S = Array(n) { sc.next() }

        // sはtの部分列かを判定
        fun isSubArray(s: String, t: String): Boolean {
            var ti = 0
            repeat(s.length) { si ->
                while (ti < t.length && s[si] != t[ti]) ti++
                if (ti == t.length) return false

                ti++
            }

            return true
        }

        fun ham(s: String): Int {
            if (s.length != t.length) return 999
            var cnt = 0
            repeat(t.length) { i -> if (t[i] != s[i]) cnt++ }

            return cnt
        }

        PrintWriter(System.out).use { out ->
            val ans = mutableListOf<Int>()
            repeat(n) { si ->
                val s = S[si]
                if (abs(s.length - t.length) > 1) return@repeat

                var ok = false
                // 部分列判定
                if (isSubArray(s, t)) ok = true
                if (isSubArray(t, s)) ok = true
                // 置換判定
                if (ham(s) <= 1) ok = true

                if (ok) ans.add(si+1)
            }

            out.println(ans.size)
            for (index in ans) {
                out.print("$index ")
            }
            out.println()
        }
    }
}
