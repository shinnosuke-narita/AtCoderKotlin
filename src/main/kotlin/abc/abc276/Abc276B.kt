package abc.abc276

class Abc276B {
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph: Array<ArrayList<Int>> = Array(n) { arrayListOf() }

        repeat(m) {
            var (a, b) = readln().split(" ").map { it.toInt() }
            a--
            b--
            graph[a].add(b)
            graph[b].add(a)
        }

        repeat(n) { i ->
            val size = graph[i].size
            print("$size ")
            graph[i].sorted().forEach { value ->
                print("${value+1} ")
            }
            println()
        }
    }
}
