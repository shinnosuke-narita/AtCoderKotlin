
class Abc276C {
    fun solve() {
        val n = readln().toInt()
        val p = readln().split(" ").map { it.toInt() }.toIntArray()

        for (i in n-2 downTo 0) {
            if (p[i] > p[i+1]) {
                var j = n-1
                while(p[i] < p[j]) j--
                val temp: Int = p[i]
                p[i] = p[j]
                p[j] = temp
                p.reverse(i+1, n)
                break
            }
        }
        repeat(n) {
            print("${p[it]} ")
        }
        println()
    }
}
fun main() {
    Abc276C().solve()
}


