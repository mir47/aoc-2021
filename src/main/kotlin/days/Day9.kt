package days

class Day9 : Day(9) {

    override fun partOne(): Int {
        var result = 0
        inputList.forEachIndexed { i, s ->
            (s.indices).forEach { j ->
                var passH = when (j) {
                    0 -> s[j].digitToInt() < s[j+1].digitToInt()
                    s.length-1 -> s[j].digitToInt() < s[j-1].digitToInt()
                    else -> s[j].digitToInt() < s[j-1].digitToInt() && s[j].digitToInt() < s[j+1].digitToInt()
                }

                var passV = when (i) {
                    0 -> s[j].digitToInt() < inputList[i+1][j].digitToInt()
                    inputList.size-1 -> s[j].digitToInt() < inputList[i-1][j].digitToInt()
                    else -> s[j].digitToInt() < inputList[i-1][j].digitToInt() && s[j].digitToInt() < inputList[i+1][j].digitToInt()
                }

                if (passH && passV) result += s[j].digitToInt() + 1
            }
        }
        return result
    }

    override fun partTwo(): Int {
        val basins = mutableMapOf<Int, Int>()
        var basinCount = 0
        var prev = MutableList(inputList[0].length) { 0 }
        var current = MutableList(inputList[0].length) { 0 }
        inputList.forEachIndexed { rowIndex, rowItem ->
            current = MutableList(inputList[0].length) { 0 }
            rowItem.forEachIndexed { pointIndex, pointItem ->
                val pointPrev = if (pointIndex == 0) 9 else rowItem[pointIndex - 1].digitToInt()
                val point = pointItem.digitToInt()

                var basin = 0
                if (point < 9) {
                    if (pointPrev < 9) {
                        basin = current[pointIndex-1]
                        basins.merge(basin, 1) { a, b -> a + b }
                        if (prev[pointIndex] > 0 && prev[pointIndex] != basin) {
                            val oldBasin = prev[pointIndex]
                            prev.forEachIndexed { index, i ->
                                if (i == oldBasin) {
                                    prev[index] = basin
                                }
                            }
                            basins.merge(basin, basins.getOrDefault(oldBasin, 0)) { a, b -> a + b }
                            basins.remove(oldBasin)
                        }
                    } else if (rowIndex > 0) {
                        if (prev[pointIndex] > 0) {
                            basin = prev[pointIndex]
                            basins.merge(prev[pointIndex], 1) { a, b -> a + b }
                        } else {
                            basinCount++
                            basin = basinCount
                            basins[basin] = 1
                        }
                    } else {
                        basinCount++
                        basin = basinCount
                        basins[basin] = 1
                    }
                }
                current[pointIndex] = basin
            }
            prev = current
        }
        val sorted = basins.toList().sortedByDescending { (key, value) -> value }
        return sorted[0].second * sorted[1].second * sorted[2].second
    }
}