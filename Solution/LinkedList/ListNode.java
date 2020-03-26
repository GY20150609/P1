package Solution.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int _data){
        val = _data;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public void add(ListNode node){
        ListNode tmp = this;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void display(){
        if(this == null){
            return;
        }
        System.out.print(this.val+" ");
        if(this.next != null){
            this.next.display();
        }
    }
}
