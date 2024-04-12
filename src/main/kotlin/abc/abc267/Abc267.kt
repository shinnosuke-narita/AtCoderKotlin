package abc.abc267
import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        val s = sc.nextLine()
        PrintWriter(System.out).use { out ->
            if (s[0] != '0') {
                out.println("No")
                return
            }

            val pinList = mutableListOf<CharArray>()
            pinList.add(charArrayOf(s[6]))
            pinList.add(charArrayOf(s[3]))
            pinList.add(charArrayOf(s[1], s[7]))
            pinList.add(charArrayOf(s[0], s[4]))
            pinList.add(charArrayOf(s[2], s[8]))
            pinList.add(charArrayOf(s[5]))
            pinList.add(charArrayOf(s[9]))

            val onLine = mutableListOf<Int>()
            val offLine = mutableSetOf<Int>()
            repeat(7) { i ->
                for (c in pinList[i]) {
                    if (c == '1') {
                        onLine.add(i)
                        break
                    }
                }

                var ok = true
                for (c in pinList[i]) {
                    if (c == '1') { ok = false }
                }
                if (ok) offLine.add(i)
            }

            val os = onLine.size
            for (i in 0 until os-1) {
                for (k in onLine[i]+1 until onLine[i+1]) {
                    if (offLine.contains(k)) {
                        out.println("Yes")
                        return
                    }
                }
            }
            out.println("No")
        }
    }
}
