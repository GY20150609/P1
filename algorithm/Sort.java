package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sort {

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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

    public static int[] quickSort(int[] array, int low, int high){

        //退出条件
        if(low>high) return array;
        int mid= low+(high-low)/2;
        int pivot= array[mid];
        int i=low;
        int j=high;
        // 遍历到中点处相遇为止
        while(i<=j){
            //左边找到第一个大于目标值的索引
            while(array[i]<pivot)
                i++;
            //右边找到第一个小于目标值的索引
            while(array[j]>pivot)
                j--;
            //确保交换的是目标值左、右两边元素
            if(i<=j){
                swap(array,i,j);
                i++;
                j--;
            }
        }
        //目标值左边部分遍历
        if(low<j)
            quickSort(array, low, j);
        //目标值右边部分遍历
        if(high>i)
            quickSort(array, i, high);
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
            quickSort2(array,left,mid);
            quickSort2(array,mid+1,right);
        }
        return array;
    }

    public static int[] heapSort(int[] array) {
        //不断建立堆并首尾元素
        for (int i = 0; i < array.length; i++) {
            initheapify(array,array.length - i);
            int temp = array[0];
            array[0] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    //以currNode为根节点建大顶堆
    public static void heapify (int[] array,int currNode,int size) {
        if (currNode < size) {
            int left = 2 * currNode + 1;
            int right = 2 * currNode + 2;
            int max = currNode;
            //左节点比较
            if(left < size) {
                if (array[left] > max) {
                    max = left;
                }
            }
            //右节点比较
            if (right < size) {
                if (array[right] > max) {
                    max = right;
                }
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
        for (int i = size - 1; i >= 0; i--) {
            heapify(array,i,size);
        }
    }

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

    public static int partition(int[] array, int left,int right) {
        int pivotVal = array[left];
        int l = left;
        int r = left + 1;
        while(r < right) {
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
        for (int i = r_s; i <= r_e; i++){
            int to_index = i - 1;
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

    public static int[][] test(int[] arr,int buckets){
        int min = arr[0], max = arr[1];
        for (int i = 0; i < arr.length; i++) {  // 第一趟扫描，找到最小值和最大值
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        int numOfBucket = (max - min + 1) / buckets + ((max - min + 1)%buckets == 0 ? 0 : 1);  // 每个桶里的元素数量
        int[] bucketNum = new int[buckets];  // 用于指示桶里是否有数据
        int[][] placeHolderArr = new int[buckets][numOfBucket];  // 存放数据
        for (int i = 0; i < arr.length; i++) {
            int bucket = (arr[i] - min) / numOfBucket;
            placeHolderArr[bucket][bucketNum[bucket]] = arr[i];
            bucketNum[bucket] = bucketNum[bucket] + 1;
        }
        return placeHolderArr;
    }

    public static void heap(int[] array, int currNode, int size) {
        if(currNode < size) {
            int left = currNode * 2 + 1;
            int right = currNode * 2 + 2;
            int max = currNode;
            if (left < size) {
                if (array[left] > array[max]) {
                    max = left;
                }
            }
            if (right < size) {
                if (array[right] > array[max]) {
                    max = right;
                }
            }
            if(max != currNode) {
                int temp = array[max];
                array[max] = array[currNode];
                array[currNode] = temp;
                heap(array,max,size);
            }
        }
    }





    public static void main(String[] args) {
        String s = "3,4,2,5,1";
        int[] t = new int[] {6,3,1,2,5,8,9};
        //System.out.println(node2num(s));
        display(quickSort2(t,0,7));
    }

}