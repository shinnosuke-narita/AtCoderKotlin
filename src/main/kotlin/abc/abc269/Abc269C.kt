package abc.abc269

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextLong()

        val bitPosList = mutableListOf<Int>()
        for (i in 0..60) {
            val res = n and (1L shl i)
            if (res != 0L) {
                bitPosList.add(i)
            }
        }

        val m = bitPosList.size
        val ans = mutableListOf<Long>()
        for (bit in 0 until (1 shl m)) {
            var res = 0L
            bitPosList.forEachIndexed { i, v ->
                if ((bit and (1 shl i)) != 0) {
                    res = res or (1L shl v)
                }
            }
            ans.add(res)
        }
        ans.sort()

        PrintWriter(System.out).use { out ->
            ans.forEach { out.println(it) }
        }
    }
}
