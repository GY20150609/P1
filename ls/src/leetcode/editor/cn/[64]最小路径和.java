//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] stage = new int[m][n];
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < n; i++){
            sum1 += grid[0][i];
            stage[0][i] =sum1;
        }
        for(int i = 0; i < m; i++){
            sum2 += grid[i][0];
            stage[i][0] =sum2;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                {
                    stage[i][j] = Math.min(stage[i-1][j] + grid[i][j],stage[i][j-1] + grid[i][j]);
                }

            }
        }
        return stage[m-1][n-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
