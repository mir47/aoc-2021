package days

class Day11 : Day(11) {

    override fun partOne(): Int {
        val input = mutableListOf<MutableList<Int>>()
        val pad = mutableListOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)
        input.add(pad)
        inputList.forEach { row ->
            val list = mutableListOf(-1)
            list.addAll(row.map { it.digitToInt() }.toMutableList())
            list.add(-1)
            input.add(list)
        }
        input.add(pad)

        var flashes = 0

        repeat(100) {
            (1..10).forEach { rowIndex ->
                (1..10).forEach { octopusIndex ->
                    if (input[rowIndex][octopusIndex] != -1) input[rowIndex][octopusIndex]++
                }
            }

            var loop = true
            while (loop) {
                loop = false
                (1..10).forEach { rowIndex ->
                    (1..10).forEach { octopusIndex ->
                        if (input[rowIndex][octopusIndex] > 9) {
                            if (input[rowIndex-1][octopusIndex-1] > 0) input[rowIndex-1][octopusIndex-1]++
                            if (input[rowIndex-1][octopusIndex]   > 0) input[rowIndex-1][octopusIndex]++
                            if (input[rowIndex-1][octopusIndex+1] > 0) input[rowIndex-1][octopusIndex+1]++
                            if (input[rowIndex] [octopusIndex-1]  > 0) input[rowIndex] [octopusIndex-1]++
                            if (input[rowIndex] [octopusIndex+1]  > 0) input[rowIndex] [octopusIndex+1]++
                            if (input[rowIndex+1][octopusIndex-1] > 0) input[rowIndex+1][octopusIndex-1]++
                            if (input[rowIndex+1][octopusIndex]   > 0) input[rowIndex+1][octopusIndex]++
                            if (input[rowIndex+1][octopusIndex+1] > 0) input[rowIndex+1][octopusIndex+1]++
                            input[rowIndex][octopusIndex] = 0
                            flashes++
                            loop = true
                        }
                    }
                }
            }
        }

        return flashes
    }

    override fun partTwo() = 0
}