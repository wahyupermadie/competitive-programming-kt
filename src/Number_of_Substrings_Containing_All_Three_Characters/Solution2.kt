package Number_of_Substrings_Containing_All_Three_Characters

/***
 * Using Windows Sliding Algorithm
 * [https://geeksforgeeks.org/window-sliding-technique/]
 */

class Solution2 {
    fun numberOfSubstrings(str: String): Int {
        val strLength = str.length
        var charOut = 0
        var charIn = 0
        var result = 0
        val data = IntArray(3) { 0 }

        while(charIn < strLength) {
            ++data[str[charIn] - 'a']
            while(data[0] > 0 && data[1] > 0 && data[2] > 0) {
                --data[str[charOut] - 'a']
                ++charOut
            }
            result += charOut
            ++charIn
        }
        return result
    }
}

fun main() {
    print(Solution2().numberOfSubstrings("bbbbac") == 8)
}