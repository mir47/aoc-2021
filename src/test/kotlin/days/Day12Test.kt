package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day12Test {

    private val day = Day12()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(226))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(0))
    }
}
