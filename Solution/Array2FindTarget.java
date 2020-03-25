package Solution;

public class Array2FindTarget {

    // 思路1 : 每一行二分查找 O(m * log(n))
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] data = array[i];
            int left = 0;
            int right = data.length - 1;
            while (right >= left) {
                int mid = left + (right - left) / 2;
                if (target > data[mid]) {
                    left = mid + 1;
                } else if (target < data[mid]) {
                    right = mid - 1;
                } else if (target == data[mid]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 思路2 : 充分利用数组上下有序
    /*
    1. 左下角元素d为本行最小，本列最大
    2. 如果target > d,说明目标值在后一列,后移1位
    3. 如果target < d,说明目标值在上一行，上移1位
    4. 相等则返回true
     */
    public boolean Find2rec(int target, int [][] array,int r,int c) {
        if (target > array[r][c]){
            Find2rec(target, array,r, c+1);
        } else if(target < array[r][c]){
            Find2rec(target, array,r-1, c);
        } else if(target == array[r][c]){
            return true;
        }
        return false;
    }

    public boolean Find2(int target, int [][] array) {
        int rowNum = array.length;
        int colNum = array[0].length;
        int r = rowNum - 1;
        int c = 0;
        while(r >=0 && c < colNum){
            if(target > array[r][c]){
                c++;
            } else if(target < array[r][c]){
                r--;
            } else if(target == array[r][c]){
                return true;
            }
        }
        return false;
    }

}
