package Minimum_Deletion_Cost_To_Avoid_Repeating_Letters

class Solution {
    fun minCost(s: String, cost: IntArray): Int {
        val strArray = s.toCharArray()
        var total = 0
        var biggestCost = 0
        var start = 1
        for(i in strArray.indices) {
            if (i >= strArray.size-1) {
                if (strArray[i] == strArray[i-1]) {
                    biggestCost = maxOf(cost[i], biggestCost)
                    total += cost[i]
                    total = (total - biggestCost)
                }
            } else if(strArray[i] == strArray[start]) {
                biggestCost = maxOf(cost[i], biggestCost)
                total+=cost[i]
            }else if(i > 0 && strArray[i] == strArray[i-1] && strArray[i] != strArray[start]) {
                total+=cost[i]
                biggestCost = maxOf(cost[i], biggestCost)
                total=(total-biggestCost)
                biggestCost = 0
            }
            ++start
        }
        return total
    }
}

fun main() {
    val array : IntArray = intArrayOf(4,9,3,8,8,9)
    print(Solution().minCost("bbbaaa",array))
}