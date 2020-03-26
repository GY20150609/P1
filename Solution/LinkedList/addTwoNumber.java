package Solution.LinkedList;


public class addTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpNode = new ListNode(0);
        ListNode cur = tmpNode;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int flag = 0;
        int res;
        //先把短的链表加完
        while(tmp1 != null || tmp2 != null){
            //计算两链表对应节点的值
            int val1 = tmp1==null ? 0 :tmp1.val;
            int val2 = tmp2==null ? 0 :tmp2.val;
            res = val1 + val2 + flag;
            //判断值是否超过10
            if(res >= 10){
                res = res - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            cur.next = new ListNode(res);
            cur = cur.next;
            if(tmp1 != null){
                tmp1 = tmp1.next;
            }
            if(tmp2 != null){
                tmp2 = tmp2.next;
            }
        }
        if(flag == 1){
            cur.next = new ListNode(1);
        }
        return tmpNode.next;
    }





}
