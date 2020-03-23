package DynamicPrograming;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

 */

import java.util.HashSet;

public class wordBreak {

    public static void display(boolean[] vv) {
        for (int i = 0; i < vv.length; i++){
            System.out.print(vv[i] + " ");
        }
    }

    public static boolean isWordBreak(String s, String[] table){
        int len = s.length();
        //stage[i]表示在第i个字符后插入空格s[0,i]是否被包含
        boolean[] stage = new boolean[len];
        int offset = 0;
        for(int i = 1; i < len; i++){
            if(offset < len){
                String tmp = s.substring(offset,i);
                stage[i-1] = isInclude(s.substring(offset,i),table);
                if(stage[i-1]){
                    offset = i;
                }
            }
        }
        display(stage);
        return stage[len-1];
    }

    public static boolean isInclude(String des,String[] table){
        for (String item : table){
            if (item.equals(des)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s = "leetcode";
        String[] wordDict = new String[] {"leet", "code"};
        isWordBreak(s,wordDict);

    }
}
