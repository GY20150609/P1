//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划
/*
思路：
1.确定状态
》最后一步
找到了最大的正方形，那么此时正好遍历到此正方形的右下角
》子问题
如果正方形右下角元素的上，左，上左都是前面遍历区域中正方形的右下角元素，那么子问题就出来了
》状态
stage[i][j]表示以该点为右下角元素的正方形最大边长（存储面积很麻烦，边长可以推断出面积）

2.状态转移方程
if(当前元素为1) satge[i][j] = min(stage[i-1][j],stage[i-1][j-1],stage[i][j-1]) + 1

3.初始状态
if(i == 0 || j ==0) stage[i][j] = matrix[i][j]

4.计算顺序
按矩阵遍历就行
 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        int tmpMax = Integer.MIN_VALUE;
        int[][] stage = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    stage[i][j] = matrix[i][j] - 48;
                }
                if(i > 0 && j > 0 && matrix[i][j] == '1'){
                    stage[i][j] = Math.min(Math.min(stage[i-1][j],stage[i][j-1]),stage[i-1][j-1]) + 1;
                }
                tmpMax = tmpMax < stage[i][j] ? stage[i][j] : tmpMax;
            }
        }
        return tmpMax*tmpMax;
    }
}
