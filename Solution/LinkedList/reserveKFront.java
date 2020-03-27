package Solution.LinkedList;

/*
反转第k个节点以前的节点
 */
public class reserveKFront {

    public static ListNode reserveKFront(ListNode head,int k){
        ListNode newNode= null;
        ListNode tmpNode = newNode;
        ListNode curNode = head;
        ListNode cNext;
        ListNode nNext;
        int index = 1;
        while(curNode != null){
            if(index < 1){
                cNext = curNode.next;
                nNext = tmpNode.next;
                tmpNode.next =

                curNode = cNext;

            } else {

            }
        }
        /*
        while(index < k){
            cNext = curNode.next;
            nNext = tmpNode.next;
            tmpNode.next = curNode;
            curNode.next = nNext;
            curNode = cNext;
            index++;
        }
         */
        return newNode.next;
    }

    public static void main(String[] artgs){
        ListNode l = new ListNode(0);
        l.add(new ListNode(1));
        l.add(new ListNode(2));
        l.add(new ListNode(3));
        reserveKFront(l,3).display();
    }
}
