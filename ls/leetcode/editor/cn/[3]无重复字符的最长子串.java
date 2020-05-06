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
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
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
        int left1 = 0;
        Map<Character,Integer> table = new HashMap<>();

        for (i = 0; i < slen; i++) {
            Character item= s.charAt(i);
            if (table.containsKey(item)) {
                left = Math.max(left,table.get(item)+1);
                left1 = table.get(item)+1;

            }
            table.put(item,i);
            tmpMax = tmpMax < i - left + 1 ? i - left + 1 : tmpMax;
        }
        return tmpMax;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
