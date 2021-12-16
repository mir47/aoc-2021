package days

class Day8 : Day(8) {

    override fun partOne(): Int {
        val r = inputList.map { it.split(" | ") }
            .map { it[1] }
            .flatMap { it.split(" ") }

        return r.count { it.length == 2 || it.length == 3 || it.length == 4 || it.length == 7 }
    }

    override fun partTwo(): Long {
        var result: Long = 0
        inputList.map { it.split(" | ") }
            .map { entry ->
                val entryPatterns: List<String> = entry[0].split(" ")
                    .map { it.toCharArray().sorted().joinToString("") }
                val entryOutputs: List<String> = entry[1].split(" ")
                    .map { it.toCharArray().sorted().joinToString("") }

                val map = mutableMapOf<Int, String>()

                entryPatterns.forEach { seg ->
                    when (seg.length) {
                        2 -> map[1] = seg
                        3 -> map[7] = seg
                        4 -> map[4] = seg
                        7 -> map[8] = seg
                    }
                }

                entryPatterns.forEach { seg ->
                    if (seg.length == 6) { // 0, 6, 9
                        var d1 = 0
                        map[4]!!.forEach { if (!seg.contains(it)) d1++ }
                        if (d1 == 0) {
                            map[9] = seg
                        } else {
                            var d2 = 0
                            map[1]!!.forEach { if (!seg.contains(it)) d2++ }
                            if (d2 == 0) {
                                map[0] = seg
                            } else {
                                map[6] = seg
                            }
                        }
                    }
                }

                entryPatterns.forEach { seg ->
                    when (seg.length) {
                        // 2, 3, 5
                        5 -> {
                            var d1 = 0
                            map[7]!!.forEach { if(!seg.contains(it)) d1++ }
                            if (d1 == 0) {
                                map[3] = seg
                            } else {
                                var d2 = 0
                                map[6]!!.forEach { if(!seg.contains(it)) d2++ }
                                if (d2 == 1) {
                                    map[5] = seg
                                } else {
                                    map[2] = seg
                                }
                            }
                        }
                    }
                }

                var output = ""
                entryOutputs.forEach { entryOutput ->
                    map.forEach { seg ->
                        if (seg.value == entryOutput) {
                            output += seg.key.toString()
                        }
                    }
                }

                result += output.toLong()
            }

        return result
    }
}