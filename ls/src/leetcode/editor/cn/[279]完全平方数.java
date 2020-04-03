//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        if( n <= 3){
            return n;
        }
        int[] stage = new int[n+1];
        stage[0] = 0;
        stage[1] = 1;
        stage[2] = 2;
        for(int i = 3; i <= n; i++){
            int tmpMin = i;
            int maxVal = (int)Math.floor(Math.sqrt(i));
            for(int j = 1; j <= maxVal; j++){
                tmpMin = Math.min(tmpMin,stage[i-j*j]+1);
            }
            stage[i] = tmpMin;
        }
        return stage[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
