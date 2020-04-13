package BasicStructure.LinkedList;

public class SingleLinkedList {

    private Node head;

    public void add(Node node){
        if(head == null){
            head = node;
        } else {
            head.add(node);
        }
    }

    public void dispaly(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.toString() + ">>");
            tmp = tmp.next;
        }
    }

    //反转链表
    public void reverse(){
        Node tmp = head;
        Node newnode = null;
        Node nextNode;
        while(tmp != null){
            nextNode = tmp.next;
            tmp.next = newnode;
            newnode = tmp;
            tmp = nextNode;
        }
        head = newnode;
    }

    //链表快排
    public static Node sqs (Node begin, Node end) {
        if(begin != end) {
            Node midNode = partition(begin,end);
            sqs(begin,midNode);
            sqs(midNode.next,end);
        }
        return begin;
    }

    public static Node partition(Node begin,Node end){
        int pivotVal = begin.data;
        Node p = begin;
        Node q = begin.next;
        while(q != end) {
            //q小于基准值移到p左边（用p指向当前节点
            if(q.data < pivotVal) {
                p = p.next;
                int temp = q.data;
                q.data = p.data;
                p.data = temp;
            }
            q = q.next;
        }
        //交换基准值与p
        int tmp = p.data;
        p.data = begin.data;
        begin.data = tmp;
        return p;
    }

    public static void main(String[] args){
        SingleLinkedList s = new SingleLinkedList();
        s.add(new Node(4));
        s.add(new Node(3));
        s.add(new Node(5));
        s.add(new Node(2));
        s.add(new Node(6));
        s.add(new Node(1));
        s.dispaly();
        System.out.println();
        //s.reverse();
        Node res = sqs(s.head,null);
        Node curNode = res;
        while(curNode != null){
            System.out.println(curNode.toString());
            curNode = curNode.next;
        }
    }



}

class Node{
    int data;
    Node next;

    public Node(int _data){
        data = _data;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public void add(Node node){
        if(this.next == null){
            this.next = node;
            return;
        }
        this.next.add(node);
    }
}
