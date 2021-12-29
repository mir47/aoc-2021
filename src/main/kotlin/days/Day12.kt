package days

class Day12 : Day(12) {

    var paths = mutableListOf<String>()

    override fun partOne(): Int {
        val pairs = inputList.map { it.split('-') }
                .map { p -> Pair(p[0], p[1]) }

        solve("start", "start", pairs)

        return paths.size
    }

    override fun partTwo() = 0

    private fun solve(point: String, currentPath: String, pairs: List<Pair<String, String>>) {
        pairs.forEach {
            if (it.first == point) {
                test(it.second, currentPath, pairs)
            } else if (it.second == point) {
                test(it.first, currentPath, pairs)
            }
        }
    }

    private fun test(connection: String, currentPath: String, pairs: List<Pair<String, String>>) {
        val newPath = "$currentPath,$connection"
        when {
            connection == "start" -> return
            connection == "end" -> paths.add(newPath)
            !isLowerCase(connection) -> solve(connection, newPath, pairs)
            isLowerCase(connection) && !currentPath.contains(connection) -> solve(connection, newPath, pairs)
        }
    }

    private fun isLowerCase(input: String) = input.contains('a')
            || input.contains('b')
            || input.contains('c')
            || input.contains('d')
            || input.contains('e')
            || input.contains('f')
            || input.contains('g')
            || input.contains('h')
            || input.contains('i')
            || input.contains('j')
            || input.contains('k')
            || input.contains('l')
            || input.contains('m')
            || input.contains('n')
            || input.contains('o')
            || input.contains('p')
            || input.contains('q')
            || input.contains('r')
            || input.contains('s')
            || input.contains('t')
            || input.contains('u')
            || input.contains('v')
            || input.contains('w')
            || input.contains('x')
            || input.contains('y')
            || input.contains('z')
}