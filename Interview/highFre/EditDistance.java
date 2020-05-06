package Interview.highFre;

public class EditDistance {

    //输入两个字符串,是否编辑距离相差1,编辑包括插入|删除|修改

    public static boolean isOneEidtDis (String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        //长为t,短为s
        if (tlen < slen) {
            String temp = s;
            s = t;
            t = temp;
        }

        int diff = tlen - slen;

        //长度差大于1
        if (diff > 1) {
            return false;
        }

        //长度差为1 长删除
        if (diff  == 1) {
            for (int i = 0; i < slen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.substring(i,slen).equals(t.substring(i,tlen))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        //长度差为0  修改
        int num = 0; //不相等元素个数
        if (diff == 0) {
            for (int i = 0; i < slen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    num++;
                }
            }
            return num == 1;
        }

        return false;
    }
}
