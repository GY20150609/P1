package Solution.LinkedList;

public class sortSolution {

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

    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.add(new ListNode(3));
        head.add(new ListNode(2));
        head.add(new ListNode(1));
        head.add(new ListNode(5));
        sortList(head).display();

    }


}
