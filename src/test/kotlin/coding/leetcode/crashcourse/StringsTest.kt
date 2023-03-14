package coding.leetcode.crashcourse

import coding.leetcode.crashcourse.Strings
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import coding.leetcode.crashcourse.Strings as SS

object StringsTest {
    @Test
    fun testProblem71() {
        Assertions.assertThat(SS.Problem71.simplifyPath("/home/"))
            .describedAs("tests case 1")
            .isEqualTo("/home")
        Assertions.assertThat(SS.Problem71.simplifyPath("/../"))
            .describedAs("tests case 2")
            .isEqualTo("/")
        Assertions.assertThat(SS.Problem71.simplifyPath("/a//b////c/d//././/.."))
            .describedAs("tests case 3")
            .isEqualTo("/a/b/c")

    }

    @Test
    fun testProblem1544() {
        Assertions.assertThat(SS.Problem1544.makeGood("leEeetcode"))
            .describedAs("tests case 1")
            .isEqualTo("leetcode")
        Assertions.assertThat(SS.Problem1544.makeGood("abBAcC"))
            .describedAs("tests case 2")
            .isEqualTo("")
        Assertions.assertThat(SS.Problem1544.makeGood("s"))
            .describedAs("tests case 3")
            .isEqualTo("s")

    }


}