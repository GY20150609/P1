package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sort {

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[] bubbleSort(int[] array){
        int length = array.length;
        int tmpVal;
        boolean flag = false;
        for (int i = 1; i < length; i++){
            for (int j = 0; j < length - i; j++){
                if (array[j] > array[j+1]){
                    tmpVal = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmpVal;
                    flag = true;
                }
            }
            if (flag == false){
                break;
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        int toIndex;
        int tmpVal;
        for (int i = 1; i < array.length; i++) {
            toIndex = i -1;
            tmpVal = array[i];
            while(toIndex >= 0 && tmpVal < array[toIndex]) {
                // 已有序，需要逐个后移
                array[toIndex+1] = array[toIndex];
                toIndex--;
            }
            array[toIndex+1] = tmpVal;
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int tmpMin = array[i];
            int tmpIndex = i;
            for (int j = i + 1; j < array.length; j ++) {
                if (tmpMin > array[j]) {
                    //直接找到最小值下标再交换
                    tmpIndex = j;
                    //array[j] = tmpMin;
                    tmpMin = array[j];
                }
            }
            array[tmpIndex] = array[i];
            array[i] = tmpMin;
        }
        return array;
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        int tmpVal = 0;
        int toIndex = 0;
        // 设置间隔
        for (int gap = len/2; gap > 0; gap = gap/2) {
            // 每个间隔的组数
            for (int i = 0; i < gap; i++) {
                // 每个组进行插入排序
                for (int j = i + gap; j < len; j = j + gap){
                    tmpVal = array[j];
                    toIndex = j - gap;
                    while(toIndex >= 0 && tmpVal < array[toIndex]) {
                        array[toIndex + gap] = array[toIndex];
                        toIndex -= gap;
                    }
                    array[toIndex + gap] = tmpVal;
                }
            }
        }
        return array;
    }

    public static int[] quickSort1(int[] array,int left,int right) {
        //结束条件
        if(left > right) {
            return array;
        }
        //基准值
        int pivotIndex = left + (right - left) / 2;
        int pivotVal = array[pivotIndex];
        int l = left;
        int r = right;
        //分别从左右两端开始遍历至l与r相遇
        while(l <= r) {
            //左半部分寻找大于基准值的索引，最多到基准值处
            while (array[l] < pivotVal) {
                l++;
            }
            //右半部分寻找小于基准值的索引，最多到基准值处
            while(array[r] > pivotVal) {
                r--;
            }
            //如果没有相遇就交换
            if(l < r){
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                //交换后索引分别前|后移一位，表示交换后的元素已经不用再移动
                l++;
                r--;
            }
            //还有种可能就是相遇到基准值处，说明两边的值已经满足要求，这时将基准值排除后，直接break;
            else if (l == r) {
                l++;
                r--;
                break;
            }
        }
        //最终肯定是r到了基准值的左侧，l到了基准值的右侧，且 l = r + 1
        quickSort1(array,left,r);
        quickSort1(array,l,right);
        return array;
    }

    public static int[] quickSort2(int[] array, int left, int right) {
        if(left < right) {
            int mid = partition(array,left,right);
            display(array);
            quickSort2(array,left,mid-1);
            quickSort2(array,mid+1,right);
        }
        return array;
    }

    public static int[] heapSort(int[] array) {
        //
        int size = array.length;
        initheapify(array,size);
        for (int i = 1; i < size; i++) {
            swap(array,0,size - i);
            //size--;
            heapify(array,0,size - i);
        }
        return array;
    }


    //整数排序
    public static int[] radixSort(int[] array){
        // 1. 获取待排数组最大值
        int maxValue = findMax(array);
        // 2. 获取最大值的位数
        int num = findValueNum(maxValue);
        // 3. 初始化存位数组,行代表位数0-9，链表存储对应数组值
        ArrayList<LinkedList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            l.add(new LinkedList<Integer>());
        }
        // 4. 逐位遍历
        for (int j = 0; j < num; j++){
            int index = 0;
            // 根据位数值放入对应数组
            for(int m = 0; m < array.length; m++){
                l.get(findValueLevel(array[m],j)).add(array[m]);
            }
            // 按位数值大小依次取出放回数组
            for (int level = 0; level < 10; level++){
                while(l.get(level).peek() != null && index < array.length){
                    array[index] = l.get(level).pop();
                    index++;
                }
            }
        }
        return array;
    }

    public static void mergeSort(int[] array,int left,int right){
        if(left < right){
            int mid = left + (right - left)/2;
            // 经典分治算法
            // 向左半部分递归划块 [left,mid]
            mergeSort(array,left,mid);
            // 向右半部分递归划块 [mid+1,right]
            mergeSort(array,mid+1,right);
            // 划块到最小单元之后，合并左右单元块 [left,mid] [mid+1,right]
            merge(array,mid+1,right);
        }
    }

    public static void bucketSort(int[] array,int bucketNum){
        //思路： 数据分桶，分桶本身就是一种局部排序，随后对每个桶里的元素进行插入排序，再依次取出
        // 1. 计算数组最大值、最小值
        int tmpMax = array[0];
        int tmpMin = array[0];
        for (int i = 1; i < array.length; i++){
            if(tmpMax < array[i]){
                tmpMax = array[i];
            }
            if(tmpMin > array[i]){
                tmpMin = array[i];
            }
        }
        // 2. 基于最大值、最小值计算桶容量
        int bucketSize;
        if ((tmpMax - tmpMin + 1)%bucketNum == 0){
            bucketSize = (tmpMax - tmpMin + 1)/bucketNum;
        } else {
            bucketSize = (tmpMax - tmpMin + 1)/bucketNum + 1;
        }
        // 3. 初始化桶数组、桶辅助数组（记录桶存储元素个数）
        int[][] buckets = new int[bucketNum][bucketSize];
        int[] bucketsAdd = new int[bucketNum];
        // 4. 依次将数组元素放入桶数组
        for(int i = 0; i < array.length; i++){
            int bucketIndex = (array[i] - tmpMin)/bucketSize;
            buckets[bucketIndex][bucketsAdd[bucketIndex]] = array[i];
            bucketsAdd[bucketIndex] += 1;
        }
        // 5. 分桶对桶数组中元素进行插入排序

    }

    //数据范围小，重复元素多,整数排序
    public static int[] countSort(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 0; i < array.length; i++) {  // 扫描一次，得到最大值和最小值  o(n)
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        int[] countArr = new int[max - min + 1];  // 新建数组存储元素频次
        for (int i = 0; i < array.length; i++) {  // o(n)
            countArr[array[i] - min] = countArr[array[i] - min] + 1;
        }
        int k = 0;
        int[] res = new int[array.length];  // ~o(n)
        for (int i = 0; i < max - min + 1; i++) {
            if (countArr[i] > 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    res[k++] = i + min;
                }
            }
        }
        return res;
    }

    //以currNode为根节点建大顶堆
    public static void heapify (int[] array,int currNode,int size) {
        if (currNode < size) {
            int left = 2 * currNode + 1;
            int right = 2 * currNode + 2;
            int max = currNode;
            //左节点比较
            if(left < size && array[left] > array[max]) {
                max = left;
            }
            //右节点比较
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            if (max != currNode) {
                int temp = array[currNode];
                array[currNode] = array[max];
                array[max] = temp;
                //交换后可能导致交换节点处不符合大顶堆性质
                heapify(array,max,size);
            }
        }

    }

    //从最后子节点开始建立堆
    public static void initheapify (int[] array, int size) {
        for (int i = size/2; i >= 0; i--) {
            heapify(array,i,size);
        }
    }

    public static int partition(int[] array, int left,int right) {
        int pivotVal = array[left];
        int l = left;
        int r = left + 1;
        //注意是遍历比较所有元素，不是前一个，如果小于号的话最后一个元素不参与比较
        while(r <= right) {
            if(array[r] < pivotVal) {
                l++;
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
            r++;
        }
        array[left] = array[l];
        array[l] = pivotVal;
        return l;
    }

    public static int[] merge(int[] array,int r_s,int r_e){
        int insertVal;
        int to_index;
        for (int i = r_s; i <= r_e; i++){
            to_index = i - 1;
            insertVal = array[i];
            while(to_index >= 0 && insertVal < array[to_index]) {
                array[to_index + 1] = array[to_index];
                to_index--;
            }
            array[to_index + 1] = insertVal;
        }
        return array;
    }

    public static void swap(int[] array,int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int findMax(int[] array){
        int tmpMax = array[0];
        for (int j = 1; j < array.length - 1; j++){
            if(tmpMax < array[j]){
                tmpMax = array[j];
            }
        }
        return tmpMax;
    }

    public static int findValueNum(int value){
        final int[] range = {9,99,999,9999,99999,99999,999999,9999999,99999999,999999999,Integer.MAX_VALUE};
        for (int i = 0; ; i++){
            if(value <= range[i]){
                return i + 1;
            }
        }
    }

    public static int findValueLevel(int value,int level){
        for (int i = 0; i < level; i++){
            value = value / 10;
        }
        return value%10;
    }



    //starting here

    public static int[] cS2(int[] array) {
        int len = array.length;
        if (len <= 1) {
            return array;
        }
        int tmpMin = array[0];
        int tmpMax = array[0];
        //确定数据范围-最大、小值
        for (int i = 1; i < len; i++) {
            tmpMin = array[i] < tmpMin ? array[i] : tmpMin;
            tmpMax = array[i] > tmpMax ? array[i] : tmpMax;
        }
        //初始化额外计数空间
        int[] countArr = new int[tmpMax - tmpMin + 1];
        //逐个计算出现次数
        for (int i = 0; i < len; i++) {
            countArr[array[i] - tmpMin] += 1;
        }
        //取出元素，存储到res
        int[] res = new int[array.length];
        int indx = 0;
        for (int i = 0; i <= tmpMax - tmpMin; i++) {
            if (countArr[i] > 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    res[indx++] = tmpMin + i;
                }
            }
        }
        return res;
    }

    public static int[] qS3(int[] array,int left,int right) {
        if (left < right) {
            int indx = partition3(array,left,right);
            qS3(array,left,indx-1);
            qS3(array,indx+1,right);
        }

        return array;
    }

    public static int partition3 (int[] array,int left,int right) {
        int pivotVal = array[left];
        int l = left;
        int r = left + 1;
        while (r <= right) {
            if (array[r] < pivotVal) {
                l++;
                swap(array,l,r);
            }
            r++;
        }
        //容易遗漏，注意交换基准值
        swap(array,left,l);
        return l;
    }

    public static void mS2(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mS2(array,left,mid);
            mS2(array,mid+1,right);
            merge2(array,mid+1,right);
        }
    }

    public static void merge2 (int[] array, int rs,int re) {
        int toInsertIndx;
        int insertVal;
        for (int i = rs; i <= re; i++) {
            insertVal = array[i];
            toInsertIndx = i - 1;
            while (toInsertIndx >= 0 && insertVal < array[toInsertIndx]) {
                array[toInsertIndx+1] = array[toInsertIndx];
                toInsertIndx--;
            }
            //注意自增顺序
            array[++toInsertIndx] = insertVal;
        }
    }

    public static int[] rS2 (int[] array) {
        int len = array.length;
        //找最大的数
        int tmpMax = array[0];
        for (int i = 1; i < len; i++) {
            tmpMax = tmpMax < array[i] ? array[i] : tmpMax;
        }
        //确定位数
        int numSize = numSize(tmpMax);



        return array;
    }

    public static int numSizeOri (int val) {
        int num = 0;
        while (val > 0) {
            val /= 10;
            num++;
        }
        return num;
    }

    public static int numSize (int val) {
        int[] range = new int[]{9,99,999,9999,99999,999999,9999999,99999999,999999999};
        for (int i = 0; i < range.length; i++) {
            if (val < range[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int numLevel (int val, int level) {

    }


    //ending here





    public static void main(String[] args) {
        String s = "3,4,2,5,1";
        int[] t = new int[] {6,3,1,2,5,8,9};
        //System.out.println(node2num(s));
        mS2(t,0,6);
        display(t);
    }

}