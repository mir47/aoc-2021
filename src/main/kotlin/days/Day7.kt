package days

import kotlin.math.absoluteValue

class Day7 : Day(7) {

    override fun partOne() = solve(0)

    override fun partTwo() = solve(1)

    private fun solve(rateDelta: Int): Long {
        val positions = inputString.split(",").map { it.toInt() }
        val max = positions.maxOrNull() ?: 0
        var cost = 0L
        var result = mutableMapOf<Int, Long>()

        (0..max).forEach { pos ->
            positions.forEach { crab ->
                val oldCost = (crab - pos).absoluteValue
                (1..oldCost).forEach {
                    cost += 1L + ((it-1) * rateDelta)
                }
            }
            result[pos] = cost
            cost = 0
        }

        return result.minOf { it.value }
    }
}