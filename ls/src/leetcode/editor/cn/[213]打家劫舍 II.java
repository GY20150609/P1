//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


/*
思路：
1.子问题
准备偷最后第n间房之前，要么偷第n-1间,要么偷第n-2间
stageno[i] 表示不抢第1间房,第i间房（i>1）的最大收益
stageyes[i] 表示抢第1间房，第i间房（i>1）的最大收益

2.状态转移方程
stage[i] = Math.max(stage[i-2] + nums[i],stage[i-1])

3.初始条件
stageno[0] = 0
stageno[1] = max(nums[1],nums[2])

stageyes[0] = nums[0]
stageyes[1] = max(nums[0],nums[1])

4.计算顺序
计算第i间房，需要提前知道i-1和i-2
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int n = nums.length;
        int[] stageno = new int[n-1];
        int[] stageyes = new int[n-1];
        //不打劫第一家
        stageno[0] = nums[1];
        stageno[1] = Math.max(nums[1],nums[2]);
        //打劫第一家
        stageyes[0] = nums[0];
        stageyes[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n-1; i++){
            //打劫第一间只能遍历到倒数第2个
            stageyes[i] = Math.max(stageyes[i-2]+nums[i],stageyes[i-1]);
            //不打劫第一间可以遍历到最后
            stageno[i] = Math.max(stageno[i-2]+nums[i+1],stageno[i-1]);
        }
        return Math.max(stageno[n-2],stageyes[n-2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
