package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        var result = 0
        inputList.forEachIndexed { index, s ->
            if (index != 0 && s.toInt() > inputList[index-1].toInt()) {
                result++
            }
        }
        return result.toString()
    }

    override fun partTwo(): Any {
        var result = 0
        var sum = 0
        var sumPrev = 0
        inputList.forEachIndexed { index, s ->
            if (index <= 2) {
                sum += s.toInt()
                sumPrev = sum
            } else {
                sum = sum + s.toInt() - inputList[index-3].toInt()
                if (sum > sumPrev) {
                    result++
                }
            }
            sumPrev = sum
        }
        return result.toString()
    }
}
