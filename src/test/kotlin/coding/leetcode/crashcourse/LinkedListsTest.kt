package coding.leetcode.crashcourse

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import coding.leetcode.crashcourse.LinkedLists as LL

object LinkedListsTest {
    @Test
    fun testProblem83() {

        val expected = LL.Problem83.deleteDuplicates(LL.Problem83.ListNode(1,
                LL.Problem83.ListNode(2)))
        Assertions.assertThat(LL.Problem83.deleteDuplicates(LL.Problem83.ListNode(1,
            LL.Problem83.ListNode(1,
                LL.Problem83.ListNode(2)))))
            .describedAs("tests case 1")
            .isEqualTo(expected)
        Assertions.assertThat(LL.Problem83.deleteDuplicates(LL.Problem83.ListNode(1,
            LL.Problem83.ListNode(1,LL.Problem83.ListNode(1,LL.Problem83.ListNode(1,
                LL.Problem83.ListNode(2)))))))
            .describedAs("tests case 2")
            .isEqualTo(expected)
    }


    @Test
    fun testProblem92() {

        var i = LL.Problem92.ListNode(1,LL.Problem92.ListNode(2,
            LL.Problem92.ListNode(3,LL.Problem92.ListNode(4,LL.Problem92.ListNode(5)))))
        var e =  LL.Problem92.ListNode(1,LL.Problem92.ListNode(4,
            LL.Problem92.ListNode(3,LL.Problem92.ListNode(2,LL.Problem92.ListNode(5)))))
        Assertions.assertThat(LL.Problem92.reverseBetween(i, 2,4))
            .describedAs("tests case 1")
            .isEqualTo(e)

         i = LL.Problem92.ListNode(3, LL.Problem92.ListNode(5))
         e = LL.Problem92.ListNode(3, LL.Problem92.ListNode(5))
        Assertions.assertThat(LL.Problem92.reverseBetween(i, 2, 2))
            .describedAs("tests case 2")
            .isEqualTo(e)

         e = LL.Problem92.ListNode(5, LL.Problem92.ListNode(3))
        Assertions.assertThat(LL.Problem92.reverseBetween(i, 1, 2))
            .describedAs("tests case 3")
            .isEqualTo(e)
    }

}