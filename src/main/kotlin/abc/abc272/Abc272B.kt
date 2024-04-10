package abc.abc272
import java.util.*

class Abc272B {
    fun solve(): Boolean {
        Scanner(System.`in`).use { sc ->
            val (n, m) = sc.nextLine().split(" ").map { it.toInt() }

            val stList = ArrayList<MutableSet<Int>>().apply {
                repeat(n) { add(mutableSetOf()) }
            }

            repeat(m) { i ->
                val k = sc.nextInt()
                val kList = IntArray(k)
                repeat(k) { ki ->
                    kList[ki] = sc.nextInt()
                    kList[ki]--
                }
                for (ki in 0 until k) {
                    for (kj in 0 until k) {
                        if (ki == kj) continue

                        stList[kList[ki]].add(kList[kj])
                    }
                }
            }

            for (i in 0 until n) {
                if(stList[i].size != n-1) {
                    return false
                }
            }

            return true
        }
    }
}

fun main() {
    val ans = if (Abc272B().solve()) "Yes" else "No"
    println(ans)
}
