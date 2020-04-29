package algorithm;

public class KMP {

    public static int KMPSearch(String source, String desp, int[] next) {
        char[] s = source.toCharArray();
        char[] p = desp.toCharArray();
        int i = 0;
        int j = 0;
        int slen = s.length;
        int plen = p.length;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                // 相当于:源字符串索引i固定,patten字符串索引j向右移动 j - next[j]个元素
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        }
        return -1;
    }

    public static int[] KMPNext(String s) {
        // next数组
        // 概念：第i个元素代表前i-1个元素字符串中相同前缀后缀子字符串的最长长度
        int[] next = new int[s.length()];
        next[0] = -1;
        // 模式字符串
        char[] strArray = s.toCharArray();
        //前缀索引
        int k = -1;
        //后缀索引
        int j = 0;
        while (j < strArray.length - 1) {
            if (k == -1 || strArray[k] == strArray[j]){
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void display(int[] s) {
        int i = 0;
        while (i < s.length) {
            System.out.print(s[i] + " ");
            i++;
        }
    }

    public static void main(String[] args) {
        String s = "ABDCABCA";
        String p = "ABC";
        int[] next = KMPNext("aaaba");
        display(next);
        //int result = KMPSearch(s,p,next);
        //System.out.println(result);
    }
}
