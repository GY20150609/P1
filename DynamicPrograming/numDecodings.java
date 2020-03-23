package DynamicPrograming;
/*
解码方法
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

思路：
1.确定状态
》最后一步
最后一个字符end,s[0,end]解码数
》子问题
去掉最后一个字符end，剩余子字符串s[0,end-1]的解码数
》状态数组
stage[i]表示字符s[0,i]解码方法数
2.转移方程
若当前字符为'0'
    若前一位字符为'2'或'1'，则stage[i] = stage[i-2]
    否则 return 0
若当前字符前一位为'1' stage[i] = stage[i-1] + stage[i-2]
若当前字符前一维为'2' && s[i]<=6 stage[i] = stage[i-1] + stage[i-2]
3.初始条件
stage[0] = 1
stage[1] = 1;
4.计算顺序
确保计算第i个字符时，i-1,i-2已经计算
 */

public class numDecodings {

    public static void display(int[] vv) {
        for (int i = 0; i < vv.length; i++){
            System.out.print(vv[i] + " ");
        }
    }

    public static int Solution(String s){
        int len = s.length();
        int[] stage = new int[len];
        stage[0] = 1;
        stage[1] = 1;
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    stage[i] = stage[i-2];
                } else {
                    stage[i] = 0;
                }
            }
            if(s.charAt(i-1) == '1'){
                stage[i] = stage[i-1] + stage[i-2];
            }
            if(s.charAt(i-1) == '2' && s.charAt(i)<=6) {
                stage[i] = stage[i - 1] + stage[i-2];
            }
        }
        display(stage);
        return 0;
    }

    public static void main(String[] args){
        String s = "6666";
        Solution(s);
    }
}
