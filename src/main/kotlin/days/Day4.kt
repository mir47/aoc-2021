package days

class Day4 : Day(4) {

    override fun partOne(): Int {
        return findWinner(getBoards()).second
    }

    override fun partTwo(): Int {
        val boards = getBoards()
        while (boards.size > 1) {
            boards.remove(findWinner(boards).first)
        }
        return findWinner(boards).second
    }

    private fun findWinner(boards: MutableList<BingoBoard>): Pair<BingoBoard?, Int> {
        inputList[0].split(",").forEach { draw ->
            boards.forEach { board ->
                board.numbers.forEach { number ->
                    if (draw.toInt() == number.number) {
                        number.marked = true
                        if (hasBingo(board, number.x, number.y)) {
                            return Pair(board, (sumUnmarked(board) * draw.toInt()))
                        }
                    }
                }
            }
        }
        return Pair(null, 0)
    }

    private fun getBoards(): MutableList<BingoBoard> {
        val boards = mutableListOf<BingoBoard>()
        for (i in 1 until inputList.size step 6) {
            val items = mutableListOf<BingoItem>()
            for (j in i+1..i+5) {
                inputList[j].chunked(3).forEachIndexed { index, s ->
                    items.add(BingoItem(s.trim().toInt(), x = index, y = ((j-2)%5)))
                }
            }
            boards.add(BingoBoard(items))
        }
        return boards
    }

    private fun hasBingo(board: BingoBoard, x: Int, y: Int): Boolean {
        val hasX = board.numbers.firstOrNull { it.x == x && !it.marked } == null
        val hasY = board.numbers.firstOrNull { it.y == y && !it.marked } == null
        return (hasX || hasY)
    }

    private fun sumUnmarked(board: BingoBoard): Int {
        return board.numbers.filter { !it.marked }.sumOf { it.number }
    }

    class BingoBoard(
        val numbers: List<BingoItem> = emptyList()
    )

    class BingoItem(
        val number: Int,
        val x: Int,
        val y: Int,
        var marked: Boolean = false,
    )
}