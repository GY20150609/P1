//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划
/*
思路：
1.子问题
第i间房偷/不偷  对应的是  偷第i间房的最大收益/不偷第i间房的最大收益
pre[i] 表示不抢第i间房的最大收益
cur[i] 表示抢第i间房的最大收益

2.状态转移方程
 temp = max(num[i]+pre[i-1],cur[i-1])
 pre[i] = cur[i-1];
 cur[i] = temp

3.初始条件
pre[0] = 0
cur[0] = 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    public int rob(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];
        pre[0] = 0;
        cur[0] = 0;
        int temp = 0;
        for(int i = 0; i < n; i++){
            temp = Math.max(nums[i]+pre[i],cur[i]);
            pre[i+1] = cur[i];
            cur[i+1] = temp;
        }
        return temp;
    }
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int pre = 0;
        int cur = 0;
        int temp = 0;
        for(int i = 0; i < n; i++){
            temp = Math.max(nums[i]+pre,cur);
            pre = cur;
            cur = temp;
        }
        return temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
