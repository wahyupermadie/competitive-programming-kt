package Check_Array_Formation_Through_Concatenation

class Solution {
    fun canFormArray(arr: IntArray, pieces: ArrayList<IntArray>): Boolean {
        val piecesMap : HashMap<Int, IntArray> = hashMapOf()
        val mPieces = IntArray(arr.size)
        var index = 0

        // convert pieces into map
        pieces.forEach {
            piecesMap.apply {
                this[it[0]] = it
            }
        }

        arr.forEachIndexed { _, i ->
            // find the arr value in the pieceMap
            if (piecesMap.containsKey(i)) {
                // store the pieceMap value to the mPieces
                piecesMap[i]?.forEach {
                    mPieces[index++] = it
                }
            }
        }

        return arr.contentEquals(mPieces)
    }
}

fun main() {
    val arr1 : IntArray = intArrayOf(91,4,64,78)
    val pieces1 = ArrayList<IntArray>()
    pieces1.apply {
        add(intArrayOf(78))
        add(intArrayOf(4,64))
        add(intArrayOf(91))
    }

    print(Solution().canFormArray(arr1, pieces1))
}