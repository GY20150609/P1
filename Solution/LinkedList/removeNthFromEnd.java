package Solution.LinkedList;

public class removeNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode slow = newNode;
        ListNode fast = newNode;
        int num = 0;
        while(fast != null){
            fast = fast.next;
            num += 1;
            if(num > n+1){
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return newNode.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.add(new ListNode(2));
        l1.display();
        System.out.print(removeNthFromEnd(l1,2));
    }


}
