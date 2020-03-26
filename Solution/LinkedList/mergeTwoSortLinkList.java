package Solution.LinkedList;

public class mergeTwoSortLinkList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode curNode = newNode;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val > tmp2.val){
                curNode.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                curNode.next = tmp1;
                tmp1 = tmp1.next;
            }
            curNode = curNode.next;
        }
        curNode.next = tmp1==null?tmp2:tmp1;
        return newNode.next;

    }
}
