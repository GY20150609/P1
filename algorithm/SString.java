package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SString {

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

    
    public static void main(String[] args) {
        String s = "adabaac";
        String o = "a";
        String n = "e";
        boolean flag= true;

        //System.out.println(sHash("ada",31,60000));
        //System.out.println(BruteForceFirst(s,p));
        //System.out.println(RabinKarpFirst(s,p));
        //System.out.println(BFReplaceAll(s,o,n));
        //System.out.println(numDistinctSubsequence("abcdddedf","abcdf"));
        boolean tmp = flag;
        System.out.println();
    } 
}
