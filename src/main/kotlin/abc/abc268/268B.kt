package abc.abc268

import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val s = sc.nextLine()
        val t = sc.nextLine()
        val sl = s.length
        val tl = t.length

        PrintWriter(System.out).use { out ->
            if (sl > tl) {
                out.println("No")
                return
            }

            var ok = true
            for (i in 0 until sl) {
                if (s[i] != t[i]) {
                    ok = false
                    break
                }
            }

            val ans = if (ok) "Yes" else "No"
            out.println(ans)
        }
    }
}
