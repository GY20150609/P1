import java.util.ArrayList;
import java.util.Stack;

public class LinkList2InvertArrayList {

    public static ArrayList<Integer> res = new ArrayList<>();

    // 思路1 ： 利用ArrayList add 方法，头插入实行倒序
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> res = new ArrayList<>();
            ListNode tmpNode = listNode;
            while(tmpNode != null){
                res.add(0,tmpNode.val);
                tmpNode = tmpNode.next;
            }
            return res;
    }

    // 思路2 ： 递归遍历到链表末尾，利用递归函数栈调用顺序实行逆序
    public static ArrayList<Integer> printListFromTailToHeadRec(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHeadRec(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }

    // 思路3 ： 栈实现链表翻转
    public static ArrayList<Integer> printListFromTailToHeadStack(ListNode listNode){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        ListNode tmpNode = listNode;
        while(tmpNode != null){
            s.push(tmpNode.val);
            tmpNode = tmpNode.next;
        }
        while(s.isEmpty() == false){
            res.add(s.pop());
        }
        return res;

    }

    // 思路4 ： 辅助指针实现翻转
    public static ArrayList<Integer> printListFromTailToHeadAddi(ListNode listNode){
        ArrayList<Integer> res = new ArrayList<>();
        ListNode preNode = null; // 末尾节点
        ListNode tmpNode = listNode; // 辅助指针遍历
        while(tmpNode != null){
            ListNode nextNode = tmpNode.next;
            tmpNode.next = preNode;
            preNode = tmpNode;
            tmpNode = nextNode;
        }
        while (preNode != null){
            res.add(preNode.val);
            preNode = preNode.next;
        }
        return res;
    }





    public static void main(String[] args){
        ListNode r1 = new ListNode(1);
        r1.next = new ListNode(2);
        r1.next.next  = new ListNode(3);
        System.out.println(printListFromTailToHeadAddi(r1));
    }

}


class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }


 }


