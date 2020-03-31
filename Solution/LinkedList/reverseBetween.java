package Solution.LinkedList;

public class reverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
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

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.add(new ListNode(2));
        head.add(new ListNode(3));
        head.add(new ListNode(4));
        head.add(new ListNode(5));
        reverseBetween(head,2,4).display();
    }

}
