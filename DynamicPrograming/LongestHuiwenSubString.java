package DynamicPrograming;

/*
题目:最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

思路：最大最小型动态规划-max
1.确定状态
》最后一步
最长字串边界一定相等，[i,j] char[i] = char[j]
》子问题
最长子串去掉边界也是回文,s[i+1,j-1]
》状态
stage[i][j]表示s[i,j]是否为回文
2.转移方程
stage[i][j] = ((stage[i+1][j-1] || j-i < 3) && char[i] == char[j])
3.初始状态和边界情况
stage[i][j] = false 单个字符肯定为回文
4.计算顺序
保证计算stage[i][j]之前stage[i+1][j-1]已经计算


 */

public class LongestHuiwenSubString {


    public static void display(boolean[][] vv) {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static String Solution(String s){
        int length = s.length();
        int right = 0;
        int left = 0;
        if (length <= 1){
            return s;
        }
        //初始化
        boolean[][] stage = new boolean[length][length];
        //计算顺序
        for (int i = length -2; i >= 0; i--){
            //初始化-单个字符为回文
            stage[i][i] = true;
            for(int j = i + 1; j < length; j++){
                //状态转移方程
                //边界情况
                if((stage[i+1][j-1] || j-i<3) && s.charAt(i) == s.charAt(j)){
                    stage[i][j] = true;
                }
                if(stage[i][j] && right-left<j-i){
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args){
        String s = "dabad";
        System.out.println(Solution(s));
    }
}
