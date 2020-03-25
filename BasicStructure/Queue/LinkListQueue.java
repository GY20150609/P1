package BasicStructure.Queue;

public class LinkListQueue {
}

class linkList{
    private node head = null;

    public linkList(){
        head = new node(' ');
    }

    public boolean isEmpty(){
        if (head.next == null){
            return true;
        }
        return false;
    }

    public void put(char c){
        node n = new node(c);
        if(isEmpty()){
            head.next = n;
        }
        node tmpNode = head;
        head.next = n;
        n.next = tmpNode.next;
    }

    public node push(){
        return head.next;
    }
}

class node {
    char data;
    node next;

    public node(char _data){
        data = _data;
        next = null;
    }
}
