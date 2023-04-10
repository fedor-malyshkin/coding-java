package coding.leetcode.crashcourse

import java.util.*
import kotlin.collections.HashMap


object Monotonic {
    /**
     * @see [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
     */
    object Problem496 {
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val stack = Stack<Int>()
            val map = HashMap<Int, Int>()

            for (i in nums2.indices) {
                while (stack.size > 0 && nums2[stack.peek()] < nums2[i]) {
                    map[nums2[stack.peek()]] = nums2[i]
                    stack.pop()
                }
                stack.add(i)
                map[nums2[i]] = -1
            }
            val res = IntArray(nums1.size)
            for (i in nums1.indices) {
                res[i] = map[nums1[i]]!!
            }

            return res
        }
    }

    /**
     * @see [901. Online Stock Span](https://leetcode.com/problems/online-stock-span/)
     */
    class Problem901() {
        private val stack: Stack<SE> = Stack()

        data class SE(val v: Int, val pushed: Int)

        fun next(price: Int): Int {
            var counter = 1
            while (stack.size > 0 && stack.peek().v <= price) {
                val popped = stack.pop()
                counter += popped.pushed
            }
            stack.add(SE(price, counter))

            return counter
        }
    }
}