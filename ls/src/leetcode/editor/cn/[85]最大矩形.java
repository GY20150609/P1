//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] res = new int[rows][cols];
        int max = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    if (arr[row][col] == '1') res[row][col] = 1;
                } else if (row == 0) {
                    if (arr[row][col] == '1') res[row][col] = res[row][col - 1] + 1;
                } else if (col == 0) {
                    if (arr[row][col] == '1') res[row][col] = res[row - 1][col] + 1;
                } else {
                    int tmp_res = 0;
                    if (arr[row][col] == '1') {
                        if (res[row - 1][col] + 1 > res[row][col - 1] + 1) tmp_res = res[row - 1][col] + 1;
                        else tmp_res = res[row][col - 1] + 1;
                    }
                    res[row][col] = tmp_res;
                }
                if (max < res[row][col]) max = res[row][col];
            }
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
