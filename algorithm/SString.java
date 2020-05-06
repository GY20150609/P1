package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class SString {

    //***********************双序列******************************************

    //字符串匹配骚方法 -Rabin Karp
    public static int sHash (String source, int magicNumber, int range) {
        if (source == null) {
            return -1;
        }
        int n = source.length();
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res * magicNumber % range + source.charAt(i);
        }
        return res % range;
    }

    public static int sHash (int code, int fcode, char f,char e) {
        int rescode;
        //减掉字符f
        rescode = code - fcode * f % 60000;
        //向左移一位
        rescode = rescode * 31 % 60000;
        //添加新字符e
        rescode = rescode + e;
        return rescode % 60000;
    }

    public static int BruteForceFirst (String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int tlen = target.length();
        if (tlen == 0) {
            return 0;
        }
        int slen = source.length();
        int i,j;
        for (i = 0;  i <= slen - tlen; i++) {
            for (j = 0; j < tlen; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                if (j == tlen -1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int RabinKarpFirst (String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int tlen = target.length();
        if (tlen == 0) {
            return 0;
        }
        int slen = source.length();
        if (tlen > slen) {
            return -1;
        }

        //Step1:计算target的hashcode O(tlen)
        int tcode = sHash(target,31,60000);

        //Step2:计算源子串的hashcode - 计算hashcode耗时还是没有节省出来 O(tlen)
        /*
        String subSource = "";
        int scode = -1;
        for (int i = 0; i <= slen - tlen; i++) {
            subSource = source.substring(i,i + tlen);
            scode = sHash(subSource,31,60000);
            if (scode == tcode) {
                if (subSource.equals(target)) {
                    return i;
                }
            }
        }

         */

        //Step2:计算源子串的hashcode - 可以利用保留前面的hashcode做加减 O(1)
        //计算第一个窗口的hashcode
        int fcode = 1;
        for (int j = 0; j < tlen - 1; j++) {
            fcode = fcode * 31 % 60000;
        }
        int scode = -1;
        for (int i = 0; i <= slen - tlen; i++) {
            if (i == 0) {
                scode = sHash(source.substring(i,tlen),31,60000);
            } else {
                //减去首个字符，向左，移位加上新进的字符
                //scode = 31 * (scode - fcode * source.charAt(i-1) % 60000) % 60000 + source.charAt(i+tlen-1);
                scode = sHash(scode,fcode,source.charAt(i-1),source.charAt(i+tlen-1));
                if (scode < 0) {
                    scode += 60000;
                }
            }
            if (scode == tcode) {
                if (source.substring(i,i+tlen).equals(target)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //单序列
    //1.满足某种条件的字串（HashSet存储不重复字符|HashMap存储字符+索引滑动窗口）
    /*
    left >> i 代表了当前的子串
    如果出现了重复元素，则left右移+1

     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }

        int slen = s.length();

        if (slen < 2) {
            return slen;
        }

        //思路1 ： HashMap 持久记忆
        int i;
        int tmpMax = 0;
        //新字串的开始索引
        int left = 0;
        Map<Character,Integer> table = new HashMap<>();

        for (i = 0; i < slen; i++) {
            Character item= s.charAt(i);
            if (table.containsKey(item)) {
                left = Math.max(left,table.get(item)+1);
            }
            table.put(item,i);
            tmpMax = tmpMax < i - left + 1 ? i - left + 1 : tmpMax;
        }
        return tmpMax;
    }


    //双序列
    /*
    1.最长公共子序列 -A,B（二维DP：max + 双索引）
    2.字符换是否能交叉组成 -S,A,B S去掉A之后是否为B (二维DP: if+ A|B双索引，索引之和可以表示S)
    3.最小编辑距离 A > B, （二维DP: min,具体操作在A种索引处发生，这里注意插入不涉及元素操作，A索引不用退位）
    4.不重复子序列个数 - A,B (二维DP: sum, B当前索引处元素和A当前索引处相不等=stage[i-1][j]，若相等则需要加上stage[i-1][j-1])
     */
    //滚动数组实现4
    public static int numDistinctSubsequence (String source,String target) {
        if (source == null || target == null) {
            return -1;
        }
        int slen = source.length();
        int tlen = target.length();
        if (tlen == 0) {
            return 1;
        }
        int[][] stage = new int[2][tlen+1];
        int now = 0, old = 0;

        for (int i = 0; i <= slen; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= tlen; j++) {
                //计算顺序要注意
                if (j == 0) {
                    stage[now][j] = 1;
                    continue;
                }

                if (i == 0) {
                    stage[now][j] = 0;
                    continue;
                }

                stage[now][j] = stage[old][j];

                if (source.charAt(i-1) == target.charAt(j-1)) {
                    stage[now][j] += stage[old][j-1];
                }

            }

        }
        return stage[now][tlen];
    }

    //交织相错字符串（interleaving string） -DP:if
    /*
    Q:
    给定三个字符串A, B, X
    判断X是否是由A, B交错在一起形成
    即A是X的子序列，去掉A后，剩下的字符组成B
    • 例子：
    • 输入：A=“aabcc” B=“dbbac”, X=“aadbbcbcac”
    • 输出：True（ X=“aadbbcbcac” ）

    S:
    思考两个子串能构成目标串需要满足什么条件？
    1.子问题 - 目标字符串最后一个字符要么来自A,要么来自B
    如果来自A,则X[-1]==A[-1],且X[0:-2]由B[0:-1]和A[0:-2]组成
    如果来自B,则X[-1]==B[-1],且X[0:-2]由B[0:-2]和A[0:-1]组成
    2.确定状态
    stage[i][j] 表示X[0:i+j-1]前i+j个字符，能否由A[0:i-1]前i个字符与B[0:j-1]前j个字符组成
    3.状态转移方程
    stage[i][j] = (stage[i-1][j] | X[i+j-1]==A[i] or stage[i][j-1] | X[i+j-1] = B[j])
    4.初始条件
    stage[0][0] = true 空串可以由A，B组成
    stage[0][:]
    stage[:][0]
    5.计算顺序
    先上后下，先左后右
     */
    public static boolean interLeavingString (String first,String second,String source) {

        int flen = first.length();
        int slen = second.length();
        int len = source.length();
        if (flen + slen != len) {
            return false;
        }
        boolean[][] stage = new boolean[flen+1][slen+1];

        //空串
        stage[0][0] = true;

        //初始化第一行，判断X能否由B表示
        for (int i = 1; i <= slen; i++) {
            if ( source.charAt(i-1) == second.charAt(i-1)) {
                stage[0][i] = true;
            } else {
                break;
            }
        }

        //初始化第一列，判断X能否由A表示
        for (int i = 1; i <= flen; i++) {
            if (source.charAt(i-1) == first.charAt(i-1)) {
                stage[i][0] = true;
            } else {
                break;
            }
        }

        boolean condition1;
        boolean condition2;

        //按计算顺序赋值
        for (int i = 1; i <= flen; i++) {
            for (int j = 1; j <= slen; j++) {
                condition1 = stage[i-1][j] && source.charAt(i+j-1) == first.charAt(i-1);
                condition2 = stage[i][j-1] && source.charAt(i+j-1) == second.charAt(j-1);
                if(condition1 || condition2) {
                    stage[i][j] = true;
                }
            }
        }
        return stage[flen][slen];
    }

    //最长公共子序列（longest common subsequence） -DP:max
    /*
    Q:
    • 给定两个字符串A，B
    • 一个字符串的子串是这个字符串去掉某些字符（可能0个）之后剩下的
    字符串
    • 找到两个字符串的最长公共子串的长度
    • 例子：
    • 输入：A=“jiuzhang”, B=“lijiang”
    • 输出：5（最长公共子串是jiang ）

    S:
    见图LCS.JPG



     */
    public static int longestCommonSubseq (String source, String target) {
        int slen = source.length();
        int tlen = target.length();
        if (source == null || target == null) {
            return -1;
        }
        if (slen == 0 || tlen == 0) {
            return 0;
        }
        int[][] stage = new int[slen+1][tlen+1];

        for (int i = 0; i <= slen; i++) {
            for (int j = 0; j <= tlen; j++) {
                //其中一个为空字符串,或者两个都为空
                if (i == 0 || j == 0) {
                    stage[i][j] = 0;
                    continue;
                }
                //都不为空
                if (source.charAt(i-1) != target.charAt(j-1)) {
                    //当前索引处两个字符不等，那么两个字符串索引分别往前退一位，看哪个公共子串长
                    stage[i][j] = Math.max(stage[i-1][j],stage[i][j-1]);
                } else {
                    //当前索引处两个字符相等，那么直接在前一位状态上+1即可
                    stage[i][j] = stage[i-1][j-1] + 1;
                }
            }
        }
        return stage[slen][tlen];
    }

    //编辑距离（Edit distance） -DP:min
    /*
    Q:
    • 给定两个字符串A，B
    • 要求把A变成B，每次可以进行下面一种操作：
    – 增加一个字符
    – 去掉一个字符
    – 替换一个字符
    • 最少需要多少次操作，即最小编辑距离
    • 例子：
    • 输入：A=“mart”, B=“karma”
    • 输出：3 (m换成k，t换成m，加上a）
    S:
    stage[i][j] 表示将A[0:i]变成B[0,j]需要的最小编辑距离

     */
    public static int shortestEditDistance (String A,String B) {
        //mart > karma 增加 替换 去掉


        return -1;
    }

    //***********************单序列******************************************
    //最长不重复子串
    /*
    Q:
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    //
    // 示例 1:
    //
    // 输入: "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    //
    //
    // 示例 2:
    //
    // 输入: "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //
    //
    // 示例 3:
    //
    // 输入: "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int longestUniqueSubstring (String source) {
        if (source == null ) {
            return -1;
        }
        int slen = source.length();
        if (slen <= 1) {
            return slen;
        }
        //HashMap实现
        Map<String,Integer> table = new HashMap<>();
        String tempstr;
        int tmpSize = 0;
        for (int i = 0; i < slen; i++) {
            tempstr = source.substring(i,i+1);
            if (table.containsKey(tempstr)) {
                tmpSize = table.size();
                if (i - table.get(tempstr) == 1) {
                    table.clear();
                } else {

                }
                table.remove(tempstr);
            } else {
                table.put(tempstr,i);
            }
        }
        return tmpSize;
    }


    public static void main(String[] args) {
        String X = "dvdg";
        String A = "ba";
        String B = "lijiang";
        System.out.println();
        //System.out.println(interLeavingString(A,B,X));
        System.out.println(longestUniqueSubstring(X));
    } 
}
