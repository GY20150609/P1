//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *
 *
 * }
 */
class Solution {
    public static ListNode sortList(ListNode head) {
        ListNode newNode = new ListNode(10000);
        ListNode newHead = newNode;
        ListNode curNode = head;
        ListNode tempNode;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            int val = curNode.val;
            if(newHead.next == null){
                curNode.next = newHead.next;
                newHead.next = curNode;
            } else if(val > newHead.next.val){
                tempNode = newHead.next;
                ListNode preNode = tempNode;
                while((val > (tempNode == null ? Integer.MAX_VALUE : tempNode.val)) && tempNode != null){
                    preNode = tempNode;
                    tempNode = tempNode.next;
                }
                preNode.next = curNode;
                curNode.next = tempNode;
            } else {
                curNode.next = newHead.next;
                newHead.next = curNode;
            }
            curNode = nextNode;
        }
        return newNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
