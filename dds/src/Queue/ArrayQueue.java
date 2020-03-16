package Queue;

import java.util.AbstractQueue;

public class ArrayQueue {

    private char[] array;
    private int length = 0;
    private int top = 0;
    private int end = 0;

    public ArrayQueue(int maxSize){
        this.array = new char[maxSize];
        this.length = maxSize;
    }

    public boolean isEmpty(){
        if (top == end){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if ((end + 1) % length == top){
            return true;
        }
        return false;
    }

    public void put(char c){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        array[end] = c;
        end = (end + 1) % length;
    }

    public char push(){
        if(isEmpty()){
            System.out.println("队列为空");
            return ' ';
        }
        char res = array[top];
        top = (top + 1) % length;
        return res;
    }

    public int size(){
        return (end - top + length) % length;
    }

    public void display(){
        for (int i = top; i < top + size(); i++){
            System.out.print(array[i % length] + " ");
        }
    }

    public static void main(String[] args){
        ArrayQueue q = new ArrayQueue(10);
        q.put('a');
        q.put('b');
        q.put('c');
        q.display();
        q.push();
        q.display();

    }
}
