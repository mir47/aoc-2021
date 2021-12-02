package days

class Day2 : Day(2) {

    override fun partOne(): Int {
        val xy = inputList
            .fold(Pair(0, 0)) { sumPair, line ->
                val dir = line.split(" ")[0]
                val units = line.split(" ")[1].toInt()
                when (dir) {
                    "forward" -> Pair(sumPair.first + units, sumPair.second)
                    "down" -> Pair(sumPair.first, sumPair.second + units)
                    "up" -> Pair(sumPair.first, sumPair.second - units)
                    else -> sumPair
                }
            }
        return xy.first * xy.second
    }

    override fun partTwo(): Int {
        var pos = Pair(0, 0)
        var aim = 0
        inputList.forEach {
            val dir = it.split(" ")[0]
            val units = it.split(" ")[1].toInt()
            when (dir) {
                "forward" -> pos = Pair(pos.first + units, pos.second + (aim * units))
                "down" -> aim += units
                "up" -> aim -= units
            }
        }
        return pos.first * pos.second
    }
}
