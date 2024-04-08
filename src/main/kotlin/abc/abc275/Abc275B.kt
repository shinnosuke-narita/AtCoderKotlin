package abc.abc275

class Abc275B {
    companion object {
        private const val sp: Long = 998244353L
    }

    private fun Long.mod(): Long {
        return this % sp
    }

    fun solve() {
        val abcdef = readln().split(" ").map { it.toLong() }.toLongArray()
        val ab = (abcdef[0].mod() * abcdef[1].mod()).mod()
        val abc = (abcdef[2].mod() * ab).mod()
        val de = (abcdef[3].mod() * abcdef[4].mod()).mod()
        val def = (abcdef[5].mod() * de).mod()
        val ans = (abc-def+sp).mod()
        println(ans)
    }
}

fun main() {
    Abc275B().solve()
}

