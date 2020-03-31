//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


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
    public ListNode partition(ListNode head, int x) {
        ListNode newNodetop = new ListNode(0);
        ListNode newNodeend = new ListNode(0);
        ListNode first = newNodetop;
        ListNode second = newNodeend;
        ListNode curNode = head;
        ListNode nextNode;
        while(curNode != null){
            nextNode = curNode.next;
            int val = curNode.val;
            if(val < x){
                first.next = curNode;
                curNode.next = null;
                first = first.next;
            }else{
                second.next = curNode;
                curNode.next = null;
                second = second.next;
            }
            curNode = nextNode;
        }
        first.next = newNodeend.next;
        return newNodetop.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
