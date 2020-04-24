package BasicStructure.Tree;

import java.util.Arrays;

public class Heap {

    private int maxSize;
    private int[] array;

    public int getMaxSize() {
        return maxSize;
    }

    public int[] getArray() {
        return array;
    }

    public void create (HeapBuilder h) {
        maxSize = h .maxSize;
        array = new int[maxSize];
        if (h.array.length <=  maxSize) {
            for (int i = 0; i < h.array.length; i++) {
                array[i] = h.array[i];
            }
        } else {
            System.out.println("数组超过最大容量！");
        }



    }

    //i节点下沉
    public void sink (int i) {


    }
    
    public void display () {
        System.out.println(Arrays.toString(array));
    }

    public static class HeapBuilder {

        private int maxSize;
        private int[] array;

        public HeapBuilder setMaxSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public HeapBuilder setArray(int[] array) {
            this.array = array;
            return this;
        }

        public HeapBuilder build () {
            return this;
        }
    }
    
    public static void main(String[] args) {
        int[] data = {5,6,2,7,1,9,8};
        Heap h = new Heap();
        h.create(new HeapBuilder()
                .setMaxSize(10)
                .setArray(data)
                .build());
        h.display();


    } 





}
