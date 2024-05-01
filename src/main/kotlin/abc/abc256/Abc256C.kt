package abc.abc256
import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val a = IntArray(n) {sc.nextInt()}

        var bases = MutableList(4) { 0 }
        var ans = 0
        repeat(n) { ai ->
            val nextField = MutableList(4) {0}
            bases[0] = 1

            bases.forEachIndexed { bi, value->
                if (value == 0) return@forEachIndexed

                val nextBase = bi+a[ai]
                if (nextBase > 3) {
                    ans++
                } else {
                    nextField[nextBase] = 1
                }
            }
            bases = nextField
        }

        PrintWriter(System.out).use { out ->
            out.println(ans)
        }
    }
}
