//给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] stage = new int[n];
        stage[0] = nums[0];
        int tmpMax = stage[0];
        for(int i = 1; i < n; i++){
            stage[i] = Math.max(stage[i-1]+nums[i],nums[i]);
            tmpMax = tmpMax < stage[i] ? stage[i] : tmpMax;
        }
        return tmpMax;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
