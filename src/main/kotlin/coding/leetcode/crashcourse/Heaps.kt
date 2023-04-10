package coding.leetcode.crashcourse

import java.util.*


object Heaps {
    /**
     * @see [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)
     */
    object Problem703 {
        class KthLargest(val k: Int, val nums: IntArray) {
            private val heap = PriorityQueue<Int>()

            init {
                for (e in nums)
                    heap.offer(e)

                while (heap.size > k)
                    heap.poll();

            }

            fun add(`val`: Int): Int {
                heap.offer(`val`)
                if (heap.size > k) heap.poll()
                return heap.peek()
            }

        }
    }
}