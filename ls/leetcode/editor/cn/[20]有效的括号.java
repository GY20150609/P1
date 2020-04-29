//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        int slen = s.length();
        if (slen == 0) {
            return true;
        }
        Stack<String> ss = new Stack<>();
        for (int i = 0; i < slen; i++) {
            if (ss.isEmpty()) {
                ss.push(s.substring(i,i+1));
                continue;
            }
            String temp = ss.peek();
            if (temp.equals("(") && s.charAt(i) == ')') {
                ss.pop();
            }
            else if (temp.equals("[") && s.charAt(i) == ']') {
                ss.pop();
            }
            else if (temp.equals("{") && s.charAt(i) == '}') {
                ss.pop();
            }
            else {
                ss.push(s.substring(i,i+1));
            }
        }
        return ss.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
