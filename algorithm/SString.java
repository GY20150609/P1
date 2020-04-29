package algorithm;

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

    
    public static void main(String[] args) {
        String s = "adabaac";
        String o = "a";
        String n = "e";
        //System.out.println(sHash("ada",31,60000));
        //System.out.println(BruteForceFirst(s,p));
        //System.out.println(RabinKarpFirst(s,p));
        //System.out.println(BFReplaceAll(s,o,n));
        System.out.println(s);
    } 
}
