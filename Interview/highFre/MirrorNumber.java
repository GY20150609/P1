package Interview.highFre;

import java.util.HashMap;
import java.util.Map;

public class MirrorNumber {

    // 旋转180°依然相同
    // "69" > true   "68" > false

    public static boolean isMirrorNumber (String source) {
        //char[] c = source.toCharArray();
        if (source == null) {
            return false;
        }
        int len = source.length();
        if (len <= 1) {
            return true;
        }
        Map<Character,Character> table = new HashMap<>();
        table.put('0','0');
        table.put('1','1');
        table.put('6','9');
        table.put('8','8');
        table.put('9','6');

        for (int i = 0; i < len; i++) {
            int j = len - i -1;
            if (table.get(source.charAt(i)) != source.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "6339";
        System.out.println(isMirrorNumber(s));
    }
}
