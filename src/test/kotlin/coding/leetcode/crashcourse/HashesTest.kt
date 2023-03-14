package coding.leetcode.crashcourse

import coding.leetcode.crashcourse.Hashes.Problem1426.countElements
import coding.leetcode.crashcourse.Hashes.Problem1832.checkIfPangram
import coding.leetcode.crashcourse.Hashes.Problem268.missingNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class HashesTest {
    @Test
    fun testProblem1832() {
        Assertions.assertThat(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
                .describedAs("tests case 1")
                .isEqualTo(true)
        Assertions.assertThat(checkIfPangram("leetcode"))
                .describedAs("tests case 2")
                .isEqualTo(false)
    }

    @Test
    fun testProblem268() {
        Assertions.assertThat(missingNumber(intArrayOf(3, 0, 1)))
                .describedAs("tests case 1")
                .isEqualTo(2)
        Assertions.assertThat(missingNumber(intArrayOf(0, 1)))
                .describedAs("tests case 2")
                .isEqualTo(2)
        Assertions.assertThat(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
                .describedAs("tests case 3")
                .isEqualTo(8)
    }

    @Test
    fun testProblem1426() {
        Assertions.assertThat(countElements(intArrayOf(1, 2, 3)))
                .describedAs("tests case 1")
                .isEqualTo(2)
        Assertions.assertThat(countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
                .describedAs("tests case 2")
                .isEqualTo(0)
    }
}