package Number_of_Substrings_Containing_All_Three_Characters

/***
 *
 * This will return Time Limit if the String its too long
 * ***/

class Solution {
    fun numberOfSubstrings(s: String): Int {
        var result : Int = 0
        val output = StringBuilder("")

        return if(s.length >= 3) {
            for(i in s.indices) {
                output.append(s[i])
                for(x in (i+1) until s.length) {
                    output.append(s[x])
                    if(output.toString().contains("a") &&
                        output.toString().contains("b") &&
                        output.toString().contains("c")) {
                        if(output.toString().length == 3) {
                            ++result
                        } else {
                            ++result
                        }
                        println(output)
                    }
                }
                output.clear()
            }
            result
        } else 0
    }
}

fun main() {
    print(Solution().numberOfSubstrings("bbbbaccccc") == 20)
}
