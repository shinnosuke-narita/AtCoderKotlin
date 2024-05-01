package abc.abc351
import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextLine().toInt()
        val a = List(n) { sc.nextLine() }
        val b = List(n) { sc.nextLine() }

        PrintWriter(System.out).use { out ->
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (a[i][j] != b[i][j]) {
                        out.printf("%d %d", i+1, j+1)
                    }
                }
            }
        }
    }
}
