package Solution.LinkedList;

/*
问题：找到环形链表入口
思路：
1.快慢指针一次相遇
2.相遇后两个指针同样的速度继续走，走到再次相遇的节点即为入口
 */
public class findCircleEntry {

    public static ListNode Solution(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //第一次相遇
        while(true){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        //第二次制造相遇
        while(true){
            if(fast == slow){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l3;
        System.out.println(Solution(l1));


    }
}
