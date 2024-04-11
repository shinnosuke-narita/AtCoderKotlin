package abc.abc270

import java.io.PrintWriter
import java.util.*
import kotlin.math.abs


fun main() {
    Scanner(System.`in`).use { sc ->
        val (goal, wall, h) = sc.nextLine().split(" ").map { it.toInt() }

        val shortRange = if (goal < 0) IntRange(goal, 0) else IntRange(0,goal)

        PrintWriter(System.out).use { out ->
            if (wall !in shortRange) {
                // スタートとゴール間に壁がない
                out.println(abs(goal-0))
                return
            }

            // スタートとゴール間に壁あり
            val range = if (wall < 0) IntRange(wall, 0) else IntRange(0, wall)
            if (h in range) {
                // ハンマーがスタートと壁間にある
                out.println(abs(goal-0))
                return
            }

            //ハンマーがスタートと壁間にない
            if ((wall > 0 && wall > h) || (wall < 0 && wall < h)) {
                // ハンマーが壁の向こう側にはない
                out.println(abs(goal-0)+abs((h*2)-0))
                return
            }

            out.println(-1)
        }
    }
}
