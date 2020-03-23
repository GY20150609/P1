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
        //stage[i]表示在第i个字符后插入空格后，字串s[0,i]是否可拆分
        boolean[] stage = new boolean[len];
        //依次遍历索引从0开始的字串
        for(int i = 0; i < len; i++){
            //判断字串是否被包含
            //若被包含则状态标记为true
            if(isInclude(s.substring(0,i+1),table)){
                stage[i] = true;
                continue;
            }
            //若不被包含，拆分子串进一步判断
            // 进一步遍历判断i以前的所有stage[j]是否为true,判断j以后的子串是否被包含
            for(int j = 0; j < i; j++){
                if(stage[j] && isInclude(s.substring(j+1,i+1),table)){
                    stage[i] = true;
                    //只要任一拆分满足条件说明子串可拆分，直接返回
                    break;
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
        String s = "aaaaaaa";
        String[] wordDict = new String[] {"aaaa", "aaa"};
        System.out.println(isWordBreak(s,wordDict));

    }
}
