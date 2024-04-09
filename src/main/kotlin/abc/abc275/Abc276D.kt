package abc.abc275
import java.util.Scanner

class Abc276D {
    private val memo = mutableMapOf<Long, Long>()
    private fun recursive(x: Long): Long {
        if (x == 0L) return 1L

        if (memo.containsKey(x)) return memo[x]!!
        val res: Long = recursive(x/2) + recursive(x/3)
        memo[x] = res

        return res
    }
    fun solve() {
        Scanner(System.`in`).use { sc ->
            val x = sc.nextLong()
            println("${recursive(x)}")
        }
    }
}

fun main() {
    Abc276D().solve()
}
