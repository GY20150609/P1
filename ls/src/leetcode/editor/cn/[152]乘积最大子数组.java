//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //如果初始化数组则需要两个数组分别存储当前元素以前的最大、最小值
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int imax = nums[0];
        int imin = nums[0];
        int tmpMax = nums[0];
        for(int i= 1; i < n; i++){
            //负数就交换
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //记录最大最小值
            imin *= nums[i];
            imax *= nums[i];
            //比较大小
            imax = Math.max(imax,nums[i]);
            imin = Math.min(imin,nums[i]);
            tmpMax = imax > tmpMax ? imax : tmpMax;
        }
        return tmpMax;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
