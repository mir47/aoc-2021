package days

import java.util.*

class Day10 : Day(10) {

    private var score = 0

    override fun partOne(): Int {
        inputList.forEach { line ->
            val stack: Stack<Char> = Stack()
            line.forEach { c ->
                when (c) {
                    '(', '[', '{', '<' -> stack.push(c)
                    ')', ']', '}', '>' -> {
                        val prev = stack.pop()
                        if ((c == ')' && prev != '(')
                                || (c == ']' && prev != '[')
                                || (c == '}' && prev != '{')
                                || (c == '>' && prev != '<')
                        ) {
                            score += getScore(c)
                        }
                    }
                }
            }
        }
        return score
    }

    override fun partTwo() = 0

    private fun getScore(c: Char) = when (c) {
        ')' -> 3
        ']' -> 57
        '}' -> 1197
        '>' -> 25137
        else -> 0
    }
}