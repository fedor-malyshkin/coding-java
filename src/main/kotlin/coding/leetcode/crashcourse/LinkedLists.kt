package coding.leetcode.crashcourse


object LinkedLists {
    /**
     * @see [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
     */
    object Problem83 {
        data class ListNode(val `val`: Int, var next: ListNode? = null)

        fun deleteDuplicates(head: ListNode?): ListNode? {
            val iv = -10000
            var cv = head?.`val`
            var cn = head
            while (cn != null) {
                while ((cn.next?.`val` ?: iv) == cv)
                    cn.next = cn.next?.next
                cn = cn.next
                cv = cn?.`val`
            }
            return head
        }
    }


    /**
     * @see [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
     */
    object Problem92 {
        data class ListNode(val `val`: Int, var next: ListNode? = null)

        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            if (head == null) return null
            if (head.next == null) return head // but without works fine

            var i = 1
            var curr: ListNode? = head
            var prev: ListNode? = null

            var leftNodeToUpdateNext: ListNode? = null
            while (curr != null && i < left) {
                leftNodeToUpdateNext = curr
                curr = curr.next
                i++
            }

            var reversedPart: ListNode? = null
            var rightNodeToUpdateNext: ListNode? = null
            while (curr != null && i <= right) {
                reversedPart = curr
                val next = curr.next
                if (rightNodeToUpdateNext == null) rightNodeToUpdateNext = curr
                curr.next = prev
                prev = curr
                curr = next
                i++
            }

            rightNodeToUpdateNext?.next = curr
            if (leftNodeToUpdateNext == null) return reversedPart
            leftNodeToUpdateNext.next = reversedPart

            return head
        }
    }
}