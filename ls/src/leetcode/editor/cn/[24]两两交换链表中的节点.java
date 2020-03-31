//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
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
    public ListNode swapPairs(ListNode head) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode preNode = newNode; //辅助指针，最终返回链表全靠它改变值
        ListNode firstNode;
        ListNode secondNode;
        while(head != null && head.next != null){
            //init
            firstNode = head;
            secondNode = head.next;

            //swap
            preNode.next = secondNode; //逐个赋值
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            //re init
            preNode = firstNode; //下次指向位置
            head = firstNode.next;
        }
        return newNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
