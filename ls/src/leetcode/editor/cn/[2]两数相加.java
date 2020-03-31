//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode newNode = new ListNode(-1);
        ListNode curNode = newNode;
        int val = 0;
        int flag = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                val = l2.val + flag;
                l2 = l2.next;
            } else if(l2 == null){
                val = l1.val + flag;
                l1 = l1.next;
            } else {
                val = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(val >= 10){
                val = val - 10;
                flag = 1;
            } else {
                //curNode.next = new ListNode(val);
                //curNode = curNode.next;
                flag = 0;
            }
            curNode.next = new ListNode(val);
            curNode = curNode.next;
        }
        if(flag > 0){
            curNode.next = new ListNode(1);
        }
        return newNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
