//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String res = "";
        String shortString = "";
        int shortLen = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int tmplen = strs[i].length();
            if (tmplen < shortLen) {
                shortString = strs[i];
                shortLen = tmplen;
            }
        }
        Set<String> s;
        int j = 0;
        while (j < shortLen) {
            s = new HashSet<>();
            for (String item : strs) {
                s.add(item.substring(j,j+1));
            }
            if (s.size() != 1) {
                break;
            } else {
                res += s.toString();
            }
            j++;
        }
        return res;

    }

    /*
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String res = "";
        String shortString = "";
        int shortLen = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int tmplen = strs[i].length();
            if (tmplen < shortLen) {
                shortString = strs[i];
                shortLen = tmplen;
            }
        }
        int j = 0;
        boolean flag = true;
        while (j < shortLen && flag) {
            for (String item : strs) {
                if (shortString.charAt(j) != item.charAt(j)) {
                    flag = false;
                }
            }
            if (flag) {
                res += shortString.charAt(j);
            }
            j++;
        }

        return res;

    }

     */
}
//leetcode submit region end(Prohibit modification and deletion)
