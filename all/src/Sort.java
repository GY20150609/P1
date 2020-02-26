
public class Sort {

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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

    public static int[] fastSort(int[] array, int left, int right) {
        int midIndex = (left + right)/2;
        int midVal = array[midIndex];
        while(true) {

        }
    }

    public static void main(String[] args) {
        String s = "3,4,2,5,1";
        //System.out.println(node2num(s));
        display(shellSort(new int[] {3,4,2,5,1}));
    }

}