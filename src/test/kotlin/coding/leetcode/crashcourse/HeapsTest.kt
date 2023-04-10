package coding.leetcode.crashcourse

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

object HeapsTest {
    @Test
    fun testProblem703() {
        val testable = Heaps.Problem703.KthLargest(3, intArrayOf(4, 5, 8, 2))
        Assertions.assertThat(intArrayOf(3,5,10,9,4).
        map { testable.add(it) })
            .describedAs("tests case 1")
            .isEqualTo(listOf(4, 5, 5, 8, 8))
    }
}