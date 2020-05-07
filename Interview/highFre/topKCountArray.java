package Interview.highFre;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class topKCountArray {

    //显示
    public static void show (int[] array) {
        System.out.println(Arrays.toString(array));
    }

    //初始化小顶堆
    public static int[] buildMinHeap (int[] array) {
        int size = array.length;
        for (int i = size / 2; i >= 0; i--) {
            heapy(array,i,size);
        }
        return array;
    }

    //下沉
    public static void heapy (int[] array,int i,int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int tmpMax = i;
        if (left < size) {
             if (array[left] < array[tmpMax]) {
                 tmpMax = left;
             }
        }
        if (right < size) {
            if (array[right] < array[tmpMax]) {
                tmpMax = right;
            }
        }
        if (tmpMax != i) {
            swap(array,i,tmpMax);
            heapy(array,tmpMax,size);
        }
    }

    public static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void topkCount (int[] array,int k) {
        int[] res = new int[k];
        int len = array.length;
        int item;
        //遍历统计出现次数
        Map<Integer,Integer> table = new HashMap<>();
        for (int i = 0; i < len; i++) {
            item = array[i];
            if (!table.containsKey(item)) {
                table.put(item,1);
            }
            else {
                table.put(item,table.get(item) + 1);
            }
        }
        /*适用于找topk大的数
        //选取前k个元素构建小顶堆
        for (int i = 0; i < k; i++) {
            res[i] = array[i];
        }
        //res = Arrays.copyOf(array,k);
        buildMinHeap(res);

        //遍历剩下元素，如果元素出现次数大于堆顶元素出现次数，则替换堆顶并重新构建堆，否则继续遍历
        for (int i = k; i < len; i++) {
            if (table.get(array[i]) > table.get(res[0])) {
                res[0] = array[i];
                buildMinHeap(res);
            }
        }
         */
        Integer[] keys = new Integer[table.size()];
        table.keySet().toArray(keys);
        for (int i = 0; i < keys.length; i++) {
            if (i < k) {
                res[i] = keys[i].intValue();
                continue;
            }
            if (table.get(keys[i].intValue()) > table.get(res[0])) {
                res[0] = keys[i].intValue();
                buildMinHeap(res);
            }
        }
        System.out.println(Arrays.toString(res));
    }


    public static void main (String[] args) {
        int[] data = new int[]{4,4,4,4,1,2,2,3,3,3};
        topkCount(data,2);
    }
}
