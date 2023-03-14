package coding.leetcode.crashcourse

import coding.leetcode.crashcourse.Hashes.Problem1426.countElements
import coding.leetcode.crashcourse.Hashes.Problem1832.checkIfPangram
import coding.leetcode.crashcourse.Hashes.Problem268.missingNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

object HashesTest {
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

    @Test
    fun testProblem2225() {
        Assertions.assertThat(
            Hashes.Problem2225.findWinners(
                listOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 6),
                    intArrayOf(5, 6),
                    intArrayOf(5, 7),
                    intArrayOf(4, 5),
                    intArrayOf(4, 8),
                    intArrayOf(4, 9),
                    intArrayOf(10, 4),
                    intArrayOf(10, 9)
                )
            )
        )
            .describedAs("tests case 1")
            .isEqualTo(listOf(listOf(1, 2, 10), listOf(4, 5, 7, 8)))
        Assertions.assertThat(
            Hashes.Problem2225.findWinners(
                listOf(
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(5, 4),
                    intArrayOf(6, 4)
                )
            )
        )
            .describedAs("tests case 2")
            .isEqualTo(listOf(listOf(1, 2, 5, 6), listOf()))
    }

    @Test
    fun testProblem1133() {
        Assertions.assertThat(Hashes.Problem1133.largestUniqueNumber(intArrayOf(5, 7, 3, 9, 4, 9, 8, 3, 1)))
            .describedAs("tests case 1")
            .isEqualTo(8)
        Assertions.assertThat(Hashes.Problem1133.largestUniqueNumber(intArrayOf(9, 9, 8, 8)))
            .describedAs("tests case 2")
            .isEqualTo(-1)
    }

    @Test
    fun testProblem1189() {
        Assertions.assertThat(Hashes.Problem1189.maxNumberOfBalloons("nlaebolko"))
            .describedAs("tests case 1")
            .isEqualTo(1)
        Assertions.assertThat(Hashes.Problem1189.maxNumberOfBalloons("loonbalxballpoon"))
            .describedAs("tests case 2")
            .isEqualTo(2)
        Assertions.assertThat(Hashes.Problem1189.maxNumberOfBalloons("leetcode"))
            .describedAs("tests case 3")
            .isEqualTo(0)
    }

    @Test
    fun testProblem383() {
        Assertions.assertThat(Hashes.Problem383.canConstruct("a", "b"))
            .describedAs("tests case 1")
            .isFalse()
        Assertions.assertThat(Hashes.Problem383.canConstruct("aa", "ab"))
            .describedAs("tests case 2")
            .isFalse()
        Assertions.assertThat(Hashes.Problem383.canConstruct("aa", "aab"))
            .describedAs("tests case 3")
            .isTrue()
    }

    @Test
    fun testProblem771() {
        Assertions.assertThat(Hashes.Problem771.numJewelsInStones("aA", "aAAbbb"))
            .describedAs("tests case 1")
            .isEqualTo(3)
        Assertions.assertThat(Hashes.Problem771.numJewelsInStones("z", "ZZZ"))
            .describedAs("tests case 2")
            .isEqualTo(0)
    }

    @Test
    fun testProblem1436() {
        Assertions.assertThat(
            Hashes.Problem1436.destCity(
                arrayListOf(
                    arrayListOf("London", "New York"),
                    arrayListOf("New York", "Lima"),
                    arrayListOf("Lima", "Sao Paulo")
                )
            )
        ).describedAs("tests case 1")
            .isEqualTo("Sao Paulo")
        Assertions.assertThat(
            Hashes.Problem1436.destCity(
                arrayListOf(
                    arrayListOf("B", "C"),
                    arrayListOf("D", "B"),
                    arrayListOf("C", "A")
                )
            )
        ).describedAs("tests case 2")
            .isEqualTo("A")
        Assertions.assertThat(
            Hashes.Problem1436.destCity(
                arrayListOf(
                    arrayListOf("A", "Z")
                )
            )
        ).describedAs("tests case 3")
            .isEqualTo("Z")

    }

    @Test
    fun testProblem930() {
        Assertions.assertThat(Hashes.Problem930.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
            .describedAs("tests case 1")
            .isEqualTo(4)
        Assertions.assertThat(Hashes.Problem930.numSubarraysWithSum(intArrayOf(0,0,0,0,0), 0))
            .describedAs("tests case 2")
            .isEqualTo(15)
    }

    @Test
    fun testProblem1659() {
        Assertions.assertThat(Hashes.Problem1695.maximumUniqueSubarray(intArrayOf(4,2,4,5,6)))
            .describedAs("tests case 1")
            .isEqualTo(17)
        Assertions.assertThat(Hashes.Problem1695.maximumUniqueSubarray(intArrayOf(5,2,1,2,5,2,1,2,5)))
            .describedAs("tests case 2")
            .isEqualTo(8)
        Assertions.assertThat(Hashes.Problem1695.maximumUniqueSubarray(intArrayOf(1000)))
            .describedAs("tests case 3")
            .isEqualTo(1000)
    }
}