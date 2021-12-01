package days

class Day1 : Day(1) {

    override fun partOne() = solve(1)

    override fun partTwo() = solve(3)

    private fun solve(size: Int) = inputList
        .asSequence()
        .map { it.toInt() }
        .windowed(size).map { it.sum() }
        .windowed(2).count { it.last() > it.first() }
}
