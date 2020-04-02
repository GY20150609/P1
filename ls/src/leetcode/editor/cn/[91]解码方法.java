//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int[] stage = new int[n+1];
        stage[0] = 1;
        stage[1] = 1;
        char cur;
        char cur1;
        char cur2;
        for(int i = 2; i <= n; i++){
            cur1 = s.charAt(i-1);
            cur2 = s.charAt(i-2);
            //判断中间位cur1是否为0
            if(cur1 == '0' && (cur2 == '1' || cur2 == '2')){
                stage[i] = stage[i-2];
            }
            //cur2大于2，中间位cur1为0，则不能解码
            else if(cur1 == '0'){
                return 0;
            }
            //正常的情况就是斐波那契公式，首位cur2为1或2,cur1<=6
            else if(cur2 == '1' || (cur2 == '2' && cur1 <= '6')){
                stage[i] = stage[i-1] + stage[i-2];
            }
            //cur2 == '2' && cur2 > '6'
            else {
                stage[i] = stage[i-1];
            }
        }
        return stage[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
