package days

import kotlin.math.absoluteValue

class Day5 : Day(5) {

    override fun partOne(): Int {
        var size = 0
        val coords = inputList
            .map { it.replace(" -> ", ",") }
            .map { it.split(",") }
            .map {
                val x1 = it[0].toInt()
                val y1 = it[1].toInt()
                val x2 = it[2].toInt()
                val y2 = it[3].toInt()
                val maxof = maxOf(x1, y1, x2, y2)
                if (maxof + 1 > size) size = maxof + 1
                Pair(Pair(x1, y1), Pair(x2, y2))
            }

        var array = Array(size) { Array(size) { 0 } }

        var max = 0

        coords.forEach {
            if (it.first.second == it.second.second) {
                if (it.first.first > it.second.first) {
                    for (i in (it.second.first) .. (it.first.first)) {
                        array[it.first.second][i]++
                        if (array[it.first.second][i] > max) max = array[it.first.second][i]
                    }
                } else {
                    for (i in (it.first.first) ..  (it.second.first)) {
                        array[it.first.second][i]++
                        if (array[it.first.second][i] > max) max = array[it.first.second][i]
                    }
                }
            } else if (it.first.first == it.second.first) {
                if (it.first.second > it.second.second) {
                    for (j in (it.second.second) .. (it.first.second)) {
                        array[j][it.first.first]++
                        if (array[j][it.first.first] > max) max = array[j][it.first.first]
                    }
                } else {
                    for (j in (it.first.second) .. (it.second.second)) {
                        array[j][it.first.first]++
                        if (array[j][it.first.first] > max) max = array[j][it.first.first]
                    }
                }
            }
        }

        var count = 0
        array.forEach { ar -> count += ar.count { it >= 2 } }
        return count
    }

    override fun partTwo(): Int {
        var size = 0
        val coords = inputList
            .map { it.replace(" -> ", ",") }
            .map { it.split(",") }
            .map {
                val x1 = it[0].toInt()
                val y1 = it[1].toInt()
                val x2 = it[2].toInt()
                val y2 = it[3].toInt()
                val maxof = maxOf(x1, y1, x2, y2)
                if (maxof + 1 > size) size = maxof + 1
                Pair(Pair(x1, y1), Pair(x2, y2))
            }

        var array = Array(size) { Array(size) { 0 } }

        var max = 0

        coords.forEach {
            if (it.first.second == it.second.second) {
                if (it.first.first > it.second.first) {
                    for (i in (it.second.first) .. (it.first.first)) {
                        array[it.first.second][i]++
                        if (array[it.first.second][i] > max) max = array[it.first.second][i]
                    }
                } else {
                    for (i in (it.first.first) ..  (it.second.first)) {
                        array[it.first.second][i]++
                        if (array[it.first.second][i] > max) max = array[it.first.second][i]
                    }
                }
            } else if (it.first.first == it.second.first) {
                if (it.first.second > it.second.second) {
                    for (j in (it.second.second) .. (it.first.second)) {
                        array[j][it.first.first]++
                        if (array[j][it.first.first] > max) max = array[j][it.first.first]
                    }
                } else {
                    for (j in (it.first.second) .. (it.second.second)) {
                        array[j][it.first.first]++
                        if (array[j][it.first.first] > max) max = array[j][it.first.first]
                    }
                }
            } else {
                var startX = 0
                var startY = 0
                var length = (it.first.first - it.second.first).absoluteValue
                var dY = 0
                if (it.first.first > it.second.first) {
                    startX = it.second.first
                    startY = it.second.second
                    dY = if (it.first.second > it.second.second) 1 else -1
                } else {
                    startX = it.first.first
                    startY = it.first.second
                    dY = if (it.first.second > it.second.second) -1 else 1
                }
                var yInc = startY
                for (j in startX..(startX + length)) {
                    array[yInc][j]++
                    yInc += dY
                }
            }
        }

        var count = 0
        array.forEach { ar -> count += ar.count { it >= 2 } }
        return count
    }
}