package DynamicPrograming;
/*
152. 乘积最大子序列
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
 */

public class maxProduct {

    public static void display(int[][] vv) {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }
    //时间复杂度O(n^2)
    public static int Solution(int[] arr){
        int len = arr.length;
        //int[][] stage = new int[len][len];
        int stage = 0;
        int pre = 0;
        int tmpMax = Integer.MIN_VALUE;
        for (int i = 0; i< len; i++){
            for(int j = 0; j < len; j++){
                if(j < i){
                    stage = Integer.MIN_VALUE;
                } else if (i == j){
                    stage = arr[i];
                } else {
                    stage = pre*arr[j];
                }
                pre = stage;
                tmpMax = Math.max(tmpMax,stage);
            }
        }
        return tmpMax;
    }

    //时间复杂度O(n)
    public static int Solution1(int[] arr){
        int imin = arr[0];
        int imax = arr[0];
        int max = arr[0];
        int tmp;
        for(int i = 1; i < arr.length; i++){
            //碰到负数则交换最大、最小值
            if(arr[i] < 0){
                tmp = imin;
                imin = imax;
                imax = tmp;
            }
            imin *= arr[i];
            imax *= arr[i];
            imin = Math.min(imin,arr[i]);
            imax = Math.max(imax,arr[i]);
            max = Math.max(imax,max);
        }

        return max;
    }

    public static void main(String[] args){
        int[] test = {-2,0,-1};
        System.out.println(Solution(test));
    }
}
