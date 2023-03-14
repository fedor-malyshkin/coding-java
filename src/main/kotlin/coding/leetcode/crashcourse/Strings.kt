package coding.leetcode.crashcourse

import java.util.*


object Strings {
    /**
     * @see [71. Simplify Path](https://leetcode.com/problems/simplify-path/)
     */
    object Problem71 {
        fun simplifyPath(path: String): String {
            val strings = path.split("/")
            val stack: Deque<String> = LinkedList()
            for (s in strings) {
                if (s.isEmpty()) continue
                if (s == "..") {
                    stack.pollLast()
                    continue
                }
                if (s == ".") continue
                stack.add(s)
            }
            return stack.joinToString("/", "/")
        }
    }

    /**
     * @see [1544. Make The String Great](https://leetcode.com/problems/make-the-string-great/)
     */
    object Problem1544 {
        private fun (Char).inverseCaps(): Char = if (this.isLowerCase()) this.uppercaseChar() else this.lowercaseChar()
        fun makeGood(s: String): String {
            val stack: Deque<Char> = LinkedList()
            for (l in s) {
                if (stack.peekLast() == l.inverseCaps()) {
                    stack.removeLast()
                    continue
                }
                stack.add(l)
            }
            return stack.joinToString("")
        }
    }
}