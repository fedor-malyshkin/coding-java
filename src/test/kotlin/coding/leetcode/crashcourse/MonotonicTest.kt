package coding.leetcode.crashcourse

import coding.leetcode.crashcourse.Monotonic
import coding.leetcode.crashcourse.Strings
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import coding.leetcode.crashcourse.Monotonic as M

object MonotonicTest {
    @Test
    fun testProblem496() {
        Assertions.assertThat(M.Problem496.nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)))
            .describedAs("tests case 1")
            .isEqualTo(intArrayOf(-1,3,-1))
        Assertions.assertThat(M.Problem496.nextGreaterElement(intArrayOf(2,4), intArrayOf(1,2,3,4)))
            .describedAs("tests case 2")
            .isEqualTo(intArrayOf(3,-1))
    }

    @Test
    fun testProblem901() {
        val testable = M.Problem901()
        Assertions.assertThat(intArrayOf(100,80,60,70,60,75,85).
            map { testable.next(it) })
            .describedAs("tests case 1")
            .isEqualTo(listOf(1, 1, 1, 2, 1, 4, 6))

    }



}