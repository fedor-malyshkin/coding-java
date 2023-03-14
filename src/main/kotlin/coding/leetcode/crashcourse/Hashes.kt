package coding.leetcode.crashcourse

import java.util.*


object Hashes {
    /**
     * @see [1832. Check if the Sentence Is Pangram](https://leetcode.com/problems/check-if-the-sentence-is-pangram/)
     */
    object Problem1832 {
        fun checkIfPangram(sentence: String): Boolean {
            val set = HashSet<Char>()
            var i = 'a'
            while (i in 'a'..'z') {
                set.add(i)
                i++
            }
            for (element in sentence)
                set.remove(element)

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
    object Problem1426 {
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

    /**
     * @see [2225. Find Players With Zero or One Losses](https://leetcode.com/problems/find-players-with-zero-or-one-losses/)
     */
    object Problem2225 {
        fun findWinners(matches: List<IntArray>): List<List<Int>> {
            val nlMap = TreeMap<Int, Int>()
            for (p in matches) {
                nlMap[p[0]] = nlMap.getOrDefault(p[0], 0) + 0
                nlMap[p[1]] = nlMap.getOrDefault(p[1], 0) + 1
            }
            return listOf(
                nlMap.filter { i -> i.value == 0 }.keys.toList(),
                nlMap.filter { i -> i.value == 1 }.keys.toList()
            )
        }
    }


    /**
     * @see [1133. Largest Unique Number](https://leetcode.com/problems/largest-unique-number/)
     */
    object Problem1133 {
        fun largestUniqueNumber(nums: IntArray): Int {
            val nlMap = TreeMap<Int, Int>()
            for (p in nums) {
                nlMap[p] = nlMap.getOrDefault(p, 0) + 1
            }
            return nlMap.filterValues { v -> v == 1 }.map { e -> e.key }.maxOrNull() ?: -1
        }
    }

    /**
     * @see [1189. Maximum Number of Balloons](https://leetcode.com/problems/maximum-number-of-balloons/)
     */
    object Problem1189 {
        fun maxNumberOfBalloons(text: String): Int {
            val map = HashMap<Char, Int>()
            for (c in text) map[c] = map.getOrDefault(c, 0) + 1
            var count = 0
            while (true) {
                for (c in "balloon") {
                    if (map.getOrDefault(c, 0) == 0) return count
                    else map[c] = map[c]!!.minus(1)
                }
                count++
            }
        }
    }

    /**
     * @see [383. Ransom Note](https://leetcode.com/problems/ransom-note/)
     */
    object Problem383 {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            val rnArr = IntArray(26)
            val mgArr = IntArray(26)

            for (l in ransomNote)
                rnArr[l - 'a'] = rnArr[l - 'a'] + 1
            for (l in magazine)
                mgArr[l - 'a'] = mgArr[l - 'a'] + 1
            for (l in ransomNote)
                if (rnArr[l - 'a'] > mgArr[l - 'a']) return false
            return true
        }

    }

    /**
     * @see [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)
     */
    object Problem771 {
        fun numJewelsInStones(jewels: String, stones: String): Int {
            val jSet = jewels.toSet()
            var count = 0
            for (l in stones)
                if (jSet.contains(l)) count++

            return count
        }

    }

    /**
     * @see [1436. Destination City](https://leetcode.com/problems/destination-city/)
     */
    object Problem1436 {
        fun destCity(paths: List<List<String>>): String {
            val spSet = paths.map { it[0] }.toSet()
            for (e in paths.map { it[1] })
                if (!spSet.contains(e)) return e
            return "SURPRIZE!"
        }
    }

    /**
     * @see [930. Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/)
     * @see [https://leetcode.com/problems/binary-subarrays-with-sum/solutions/186647/java-clean-solution-2-sum-prefix-sum-caching/]
     */
    // prefix[j] - prefix[i-1] = target ==> prefix[i-1] = prefix[j] - target
    object Problem930 {
        fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
            val presum = HashMap<Int, Int>()
            //Prefix sum
            var sum = 0
            //Answer
            var total = 0
            for (el in nums) {
                sum += el
                if (sum == goal) total++
                presum[sum - goal].let { total += it ?: 0 }
                //Also put this sum into the map as well
                presum[sum] = presum.getOrDefault(sum, 0) + 1
            }
            return total
        }
    }


    /**
     * @see [1695. Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)
     */
    object Problem1695 {
        fun maximumUniqueSubarray(nums: IntArray): Int {
            val lastIndex: MutableMap<Int, Int> = HashMap()
            val prefixSum = IntArray(nums.size + 1)

            var maxScore = 0
            var l = 0
            var r = 0
            while (r < nums.size) {
                prefixSum[r + 1] = prefixSum[r] + nums[r]
                if (lastIndex.containsKey(nums[r])) l = Math.max(l, lastIndex[nums[r]]!! + 1)
                maxScore = Math.max(maxScore, prefixSum[r + 1] - prefixSum[l])
                lastIndex[nums[r]] = r
                r++
            }

            return maxScore
        }
    }
}