//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //遍历顺序很重要，从后往前遍历
        int n = s.length();
        boolean[] stage = new boolean[n+1];
        stage[0] = true;
        String res1 = "";
        String res2 = "";
        for(int i = 0; i < n; i++){
            res1 = res1 + s.charAt(i);
            res2 = res2 + s.charAt(i);
            for(String item : wordDict){
                if((res2.equals(item) && stage[i - res2.length() + 1]) || (res1.equals(item) && stage[i - res1.length() + 1])){
                    stage[i+1] = true;
                    res1 = "";
                    break;
                }
            }
        }
        return stage[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
