package Solution.LinkedList;

public class swapPairs {
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
