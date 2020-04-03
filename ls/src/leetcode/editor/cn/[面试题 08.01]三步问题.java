//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
////0000007。
////
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToStep(int n) {
        long[] stage  =  new long[n + 1];
        if(n <= 2){
            return n;
        }
        stage[1] = 1;
        stage[2] = 2;
        stage[3] = 4;
        for(int i = 4; i <= n; i++){
            stage[i] = (stage[i-1]% 1000000007 + stage[i-2]% 1000000007 + stage[i-3]% 1000000007) % 1000000007;
        }
        return (int)stage[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
