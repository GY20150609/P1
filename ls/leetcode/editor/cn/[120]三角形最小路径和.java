//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] stage = new int[n];
        stage[0] = triangle.get(0).get(0);
        int index = 0;
        for (int i = 1; i < n; i++){
            int m = triangle.get(i);
            int tmpMin = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if(triangle.get(i).get(j) > tmpMin) {
                    if(j - index == 0 || j - index == 1) {
                        tmpMin = triangle.get(i).get(j);
                        index = j;
                    }
                    stage[i] = stage[i-1] + tmpMin;
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
