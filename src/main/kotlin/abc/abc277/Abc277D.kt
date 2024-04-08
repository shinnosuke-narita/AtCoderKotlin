package abc.abc277

import kotlin.math.max

class Abc277D {
    class UnionFind {
        val parentNode: MutableList<Int>
        val groupSize: MutableList<Int>

        constructor(n: Int) {
            parentNode = MutableList(n) { -1 }
            groupSize = MutableList(n) { 1 }
        }

        /**
         * 根を求める
         */
        fun root(x: Int): Int {
            return if (parentNode[x] == -1) {
                x // x が根の場合は x を返す
            } else {
                root(parentNode[x])
            }
        }

        /**
         * x と y が同じグループに属するかどうか
         * (根が一致するかどうか)
         */
        fun isSameGroup(x: Int, y: Int): Boolean {
            return root(x) == root(y)
        }

        /**
         * x を含むグループと y を含むグループとを併合する
         */
        fun unite(x: Int, y: Int): Boolean {
            // x, y をそれぞれ根まで移動する
            val xx = root(x)
            val yy = root(y)

            // すでに同じグループのときは何もしない
            if (xx == yy) return false

            // union by size (y 側のサイズが小さくなるようにする)
            if (groupSize[xx] < groupSize[yy]) {
                parentNode[xx] = yy
                groupSize[yy] = groupSize[yy] + groupSize[xx]
            } else {
                parentNode[yy] = xx
                groupSize[xx] = groupSize[xx] + groupSize[yy]
            }
            return true
        }

        /**
         * x を含むグループのサイズ
         */
        fun size(x: Int): Int {
            return groupSize[root(x)]
        }


        /**
         * このUnionFind内のグループの個数
         */
        fun groupCount(): Int {
            return parentNode.count { it == -1 }
        }
    }

    fun solve() {
        // 空白区切りで複数値の受け取り
        val (n, m) = readln().split(" ").map { it.toInt() }
//    val a = IntArray(n) { readln().toInt() }
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        val sortedA = a.sorted()

        val uf = UnionFind(n)
        sortedA.forEachIndexed { i, v ->
            val j = (i+1)%n

            if (sortedA[j] == v || sortedA[j] == (v+1)%m) uf.unite(i, j)
        }

        val groupTotal = Array<Long>(n) {0L}
        repeat(n) { i ->
            val root = uf.root(i)
            groupTotal[root] += sortedA[i].toLong()
        }

        var mx = 0L
        groupTotal.forEach {
            mx = max(mx, it)
        }
        var total = 0L
        a.forEach { total += it }
        val ans: Long = total - mx

        println(ans)
    }
}