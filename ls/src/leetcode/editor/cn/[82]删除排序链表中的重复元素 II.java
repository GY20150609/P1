//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


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
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode curNode = newNode;
        ListNode tempNode;
        while(curNode.next != null && curNode.next.next != null){
            if(curNode.next.val != curNode.next.next.val){
                tempNode = curNode;
                while(tempNode.next.val != tempNode.next.next.val){
                    tempNode = tempNode.next;
                }
                curNode = tempNode.next;
            } else{
                curNode = curNode.next;
            }
        }
        return newNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
