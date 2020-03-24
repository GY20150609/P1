package LinkedList;

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

    public static void main(String[] args){
        SingleLinkedList s = new SingleLinkedList();
        s.add(new Node(1));
        s.add(new Node(2));
        s.reverse();
        s.dispaly();
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
        if(this.next != null){
            this.next.add(node);
        }
        this.next = node;
    }
}
