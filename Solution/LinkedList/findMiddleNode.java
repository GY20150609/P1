package Solution.LinkedList;

import Solution.LinkedList.ListNode;

/*
问题：找到中间节点
1.一次遍历
2.返回第n/2个节点
 */


public class findMiddleNode {

    public static ListNode Solution(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next == null){
                break;
            }
        }
        return fast.next == null ? slow : slow.next;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.add(new ListNode(2));
        l.add(new ListNode(3));
        l.add(new ListNode(4));
        System.out.println(Solution(l).toString());
    }
}
