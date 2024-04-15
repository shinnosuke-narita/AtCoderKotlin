package abc.abc265
import java.io.PrintWriter
import java.util.*

fun main() {
    Scanner(System.`in`).use { sc ->
        PrintWriter(System.out).use { out ->
            val (n, m, t) = sc.nextLine().split(" ").map { it.toInt() }
            val costs = IntArray(n-1) { sc.nextInt() }
            val mp = mutableMapOf<Int, Int>()
            sc.nextLine()
            repeat(m) {
                val (x, y) = sc.nextLine().split(" ").map { it.toInt() }
                mp[x-1] = y
            }

            var currentTime: Long = t.toLong()
            var currentRoom = 0
            while(true) {
                if (currentRoom == n-1) {
                    out.println("Yes")
                    break
                }
                if (mp.containsKey(currentRoom)) {
                    currentTime += mp[currentRoom]!!
                }
                if (currentTime - costs[currentRoom] <= 0) {
                    out.println("No")
                    return
                }

                currentTime -= costs[currentRoom]
                currentRoom++
            }
        }
    }
}
