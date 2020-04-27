package BasicStructure.Tree;

import java.util.Arrays;

public class Heap2 {

    private int[] data;

    private int size;

    public Heap2(int maxSize) {
        size = maxSize;
    }

    public void init (int[] array) {
        try {
            data = array;
        } catch (Exception e) {
            System.out.println("Input size is out of max size!");
        }
    }

    public void add (int val) {
        try {

        } catch (Exception e) {
            System.out.println("The heap is full!");
        }
    }

    //以当前节点为根节点进行进行构建
    public void heapy (int i, int end) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;
        if (left <= end && data[maxIndex] < data[left]) {
            maxIndex = left;
        }
        if (right <= end && data[maxIndex] < data[right]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            swap(data,i,maxIndex);
            heapy(maxIndex,end);
        }

    }

    //完整创建
    public void build (int end) {
        int n = data.length;
        int index = n / 2 - 1;
        for (int i = index; i >= 0; i--) {
            heapy(i,end);
        }
    }

    //排序
    public void sort () {
        int n = data.length;
        build(n-1);
        for (int i = 1; i <= n - 1; i++) {
            swap(data,0,n-i);
            build(n-i-1);
        }
    }

    public static void bigHeapy (int[] data,int n) {
        int i;
        int nonLeafIndex = n / 2 - 1;
        for (i = nonLeafIndex; i >= 0; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int tmpIndex = i;
            if (left < n && data[tmpIndex] < data[left]) {
                tmpIndex = left;
            }
            if (right < n && data[tmpIndex] < data[right]) {
                tmpIndex = right;
            }
            if (tmpIndex != i) {
                swap(data,i,tmpIndex);
            }
        }
    }

    public static void smallHeapy (int[] data,int n) {
        int i;
        int nonLeafIndex = n / 2 - 1;
        for (i = nonLeafIndex; i >= 0; i--) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int tmpIndex = i;
            if (left < n && data[tmpIndex] > data[left]) {
                tmpIndex = left;
            }
            if (right < n && data[tmpIndex] > data[right]) {
                tmpIndex = right;
            }
            if (tmpIndex != i) {
                swap(data,i,tmpIndex);
            }
        }
    }

    public static void heapS (int[] data,String mode) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if (mode == "asc") {
                bigHeapy(data,n-i);
            } else {
                smallHeapy(data,n-i);
            }
            swap(data,0,n-1-i);
        }
    }

    public static void swap (int[] data,int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main (String[] args) {
        int[] data = {6,10,7,2,15,5,8};
        //Heap h = new Heap(data);
        //h.build(6);
        //h.add();
        System.out.println(Arrays.toString(data));
    }
}
