//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newNode = new ListNode(0);
        ListNode shead = newNode;
        ListNode ehead = newNode;
        ListNode curNode = head;
        int index = 1;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            //S1:找到待翻转前一个节点
            if(index < m){
                ehead = curNode.next;
                shead.next = curNode;
                curNode.next = null;
                shead = shead.next;

            }
            //S2:依次插入
            else if(index >= m && index <= n){
                ListNode nNode = shead.next;
                shead.next = curNode;
                curNode.next = nNode;
            }
            //S3:继续插入
            else {
                ehead.next = curNode;
            }
            index++;
            curNode = nextNode;
        }
        return newNode.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
