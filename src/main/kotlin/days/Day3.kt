package days

class Day3 : Day(3) {

    override fun partOne(): Int {
        var gamma = ""
        var epsilon = ""
        for (bitIndex in 0.until(inputList[0].length)) {
            val counts = inputList.groupingBy { it[bitIndex] }.eachCount()
            gamma += if ((counts['0'] ?: 0) > (counts['1'] ?: 0)) '0' else '1'
            epsilon += if ((counts['0'] ?: 0) > (counts['1'] ?: 0)) '1' else '0'
        }
        return multiplyBinaryStrings(gamma, epsilon)
    }

    override fun partTwo(): Int {
        val o2: String = filter(inputList, bitIndex = 0, fewer = false)
        val co2: String = filter(inputList, bitIndex = 0, fewer = true)
        return multiplyBinaryStrings(o2, co2)
    }

    private fun filter(list: List<String>, bitIndex: Int, fewer: Boolean): String {
        return if (list.size == 1) {
            list.first()
        } else {
            val groups = list.groupBy( { it[bitIndex] }, { it } )
            val filtered = if (fewer) {
                if ((groups['0']?.size ?: 0) <= (groups['1']?.size ?: 0)) groups['0'] else groups['1']
            } else {
                if ((groups['0']?.size ?: 0) > (groups['1']?.size ?: 0)) groups['0'] else groups['1']
            }
            filter(filtered ?: emptyList(), bitIndex+1, fewer)
        }
    }

    private fun multiplyBinaryStrings(a: String, b: String) =
        Integer.parseInt(a, 2) * Integer.parseInt(b, 2)
}