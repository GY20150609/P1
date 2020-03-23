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

    public static int Solution(int[] arr){
        int len = arr.length;
        int[][] stage = new int[len][len];
        for (int i = 0; i< len; i++){
            for(int j = 0; j < len; j++){
                if(j < i){
                    stage[i][j] = Integer.MIN_VALUE;
                } else if (i == j){
                    stage[i][j] = arr[i];
                } else {
                    stage[i][j] = stage[i][j-1]*arr[j];
                }
            }
        }
        display(stage);

        return -1;
    }

    public static void main(String[] args){
        int[] test = {-2,0,-1};
        Solution(test);
    }
}
