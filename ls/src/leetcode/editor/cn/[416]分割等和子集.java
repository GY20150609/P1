//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return false;
        }
        if(n == 2){
            if(nums[0] == nums[1]){
                return true;
            } else {
                return false;
            }
        }
        //排序
        Arrays.sort(nums);
        //双索引遍历
        int i = 1;
        int j = n - 2;
        int curSum1 = nums[0];
        int curSum2 = nums[j+1];
        while(i <= j){
            if(curSum1 < curSum2){
                curSum1 += nums[i];
                i++;
            } else {
                curSum2 += nums[j];
                j--;
            }
        }
        return curSum1 == curSum2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
