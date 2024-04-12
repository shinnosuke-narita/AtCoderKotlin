package abc.abc270

import java.io.PrintWriter
import java.util.*
import kotlin.math.abs

private fun inRange(l: Int, r: Int, value: Int): Boolean {
    var ll = l
    var rr = r
    if (l > r) {
        ll = r
        rr = l
    }

    return value in (ll + 1)..<rr
}

fun main() {
    Scanner(System.`in`).use { sc ->
        val (goal, wall, h) = sc.nextLine().split(" ").map { it.toInt() }

        PrintWriter(System.out).use { out ->
            if (!inRange(0, goal, wall)) {
                // スタートとゴール間に壁がない
                out.println(abs(goal))
                return
            }

            // スタートとゴール間に壁あり
            if (inRange(0, wall, h)) {
                // ハンマーがスタートと壁間にある
                out.println(abs(goal))
                return
            }

            //ハンマーがスタートと壁間にない
            if ((wall > 0 && wall > h) || (wall < 0 && wall < h)) {
                // ハンマーが壁の向こう側にはない
                out.println(abs(goal)+abs((h*2)))
                return
            }

            out.println(-1)
        }
    }
}
