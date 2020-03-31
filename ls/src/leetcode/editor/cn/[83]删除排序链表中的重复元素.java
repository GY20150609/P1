//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode curNode = newNode;
        ListNode tempNode;
        while(curNode.next != null && curNode.next.next != null){
            if(curNode.next.val == curNode.next.next.val){
                tempNode = curNode;
                while(tempNode.next != null && tempNode.next.next != null && tempNode.next.val == tempNode.next.next.val){
                    tempNode = tempNode.next;
                }
                curNode.next = tempNode.next;
            } else{
                curNode = curNode.next;
            }
        }
        return newNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
