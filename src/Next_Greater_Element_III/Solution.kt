package Next_Greater_Element_III

class Solution {
    fun nextGreaterElement(n: Int): Int {
        val value = n.toString()
        val index :Int = value.length - 2
        return when {
            n > Integer.MAX_VALUE -> -1
            value.length > 2 -> {
                val result = processInput(value)
                return if (result > n) result else -1
            }
            value.length == 2 -> {
                val result = swap(value, index, value.length-1).toInt()
                return if (result > n) result else -1
            }
            else -> -1
        }
    }

    private fun swap(arr: String, i: Int, j: Int): String {
        val charArray = arr.toCharArray()
        val temp = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = temp
        return String(charArray)
    }

    private fun processInput(value: String): Int {
        var str = value
        var firstIndex = value.length -2
        var secondIndex = value.length -1
        for(i in firstIndex downTo 0) {
            if(str[i] < str[i+1] && firstIndex >= 0) {
                firstIndex = i
                break
            }
        }

        for (i in secondIndex downTo firstIndex) {
            if (str[i] > str[firstIndex] && secondIndex >= firstIndex) {
                break
            } else {
                --secondIndex
            }
        }

        str = swap(str, firstIndex, secondIndex)
        str = sorting(str, firstIndex+1)

        return if (str.toLong() > Integer.MAX_VALUE) -1 else str.toInt()
    }

    private fun sorting(value: String, index:Int) : String {
        val charArray = value.toCharArray()
        for(i in index until charArray.size) {
            for(x in i until charArray.size) {
                val temp = charArray[i]
                if (charArray[i] > charArray[x]) {
                    charArray[i] = charArray[x]
                    charArray[x] = temp
                }
            }
        }
        return String(charArray)
    }
}

fun main() {
    println(Solution().nextGreaterElement(12443322) == 13222344)
    println(Solution().nextGreaterElement(109465) == 109546)
    println(Solution().nextGreaterElement(21) == -1)
    println(Solution().nextGreaterElement(12) == 21)
    println(Solution().nextGreaterElement(1) == -1)
    println(Solution().nextGreaterElement(230241) == 230412)
}