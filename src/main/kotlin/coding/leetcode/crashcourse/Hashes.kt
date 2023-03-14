package coding.leetcode.crashcourse

object Hashes {
    /**
     * @see [1832. Check if the Sentence Is Pangram](https://leetcode.com/problems/check-if-the-sentence-is-pangram/)
     */
    object Problem1832 {
        fun checkIfPangram(sentence: String): Boolean {
            val set = HashSet<Char>()
            var i = 'a'
            while (i <= 'z') {
                set.add(i)
                i++
            }
            for (i in 0 until sentence.length) {
                val c = sentence[i]
                set.remove(c)
            }
            return set.isEmpty()
        }
    }

    /**
     * @see [268. Missing Number](https://leetcode.com/problems/missing-number/)
     */
    object Problem268 {
        fun missingNumber(nums: IntArray): Int {
            val set = HashSet<Any>()
            for (n in nums) set.add(n)
            for (i in 0..nums.size) {
                if (!set.contains(i)) return i
            }
            return -1
        }
    }

    /**
     * @see [1426. Counting Elements](https://leetcode.com/problems/counting-elements/)
     */
     object  Problem1426 {
         fun countElements(arr: IntArray): Int {
            val hashSet = HashSet<Any>()
            for (x in arr) {
                hashSet.add(x)
            }
            var count = 0
            for (x in arr) {
                if (hashSet.contains(x + 1)) {
                    count++
                }
            }
            return count
        }
    }
}