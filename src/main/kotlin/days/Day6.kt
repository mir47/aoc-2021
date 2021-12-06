package days

class Day6 : Day(6) {

    override fun partOne() = solve(80)

    override fun partTwo() = solve(256)

    private fun solve(numDays: Int): Long {
        val days = inputString.split(",")
            .map { it.toInt() }
            .groupingBy { it }.eachCount()
            .map { it.key to it.value.toLong() }.toMap().toMutableMap()

        repeat(numDays) {
            (days[0] ?: 0).let { first ->
                0.until(8).forEach { days[it] = days[it+1] ?: 0 }
                days[6] = (days[6] ?: 0) + first
                days[8] = first
            }
        }

        return days.values.sum()
    }
}