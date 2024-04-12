package abc.abc268

import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val p = IntArray(n) { sc.nextInt() }

        /** cnt[i] = i/n回転した時に喜ぶ人の数 */
        val cnt = IntArray(n) {0}
        repeat(n) { i ->
            val dis =  n - i // 人0の正面にするための操作回数
            val mid = dis + p[i] // 料理p[i]
            cnt[(mid-1) % n]++
            cnt[(mid) % n]++
            cnt[(mid+1) % n]++
        }

        var ans = 0
        repeat(n) { i -> ans = max(ans, cnt[i]) }

        PrintWriter(System.out).use { out ->
            out.println(ans)
        }
    }
}
