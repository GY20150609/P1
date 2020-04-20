import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;

public class demo {

    List<List<Integer>> result;

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if( m == 0 || n ==0){
            return 0;
        }
        int tmpMax = Integer.MIN_VALUE;
        int[][] stage = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    stage[i][j] = matrix[i][j] - 48;
                }else if(matrix[i][j] == '1'){
                    stage[i][j] = Math.min(Math.min(stage[i-1][j],stage[i][j-1]),stage[i-1][j-1]) + 1;
                }
                tmpMax = tmpMax < stage[i][j] ? stage[i][j] : tmpMax;
            }
        }
        return tmpMax*tmpMax;
    }

    public static int numOfSquare(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            int square = (int) Math.sqrt(i);
            if (square * square == i) {
                res[i] = 1;
            } else {
                int min = i;
                for (int j = 1; j <= i/2; j++) {
                    int tmp = res[j] + res[i - j];
                    if (min > tmp) min = tmp;
                }
                res[i] = min;
            }
        }
        return res[n];
    }



    public static boolean divisorGame(int N) {
        if (N == 1){
            return false;
        }
        boolean[] stage = new boolean[N+1];
        stage[1] = false;
        stage[2] = true;
        for(int i = 3; i <= N; i ++){
            int index = 1;
            while(index < i){
                //Alice选index之后,判断stage[i-index]能不能赢，
                if(i % index == 0 && !stage[i - index]){
                    stage[i] = true;
                    break;
                } else {
                    stage[i] = false;
                }
                index++;
            }
        }
        return stage[N];
    }


    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 2){
            if(nums[0] == nums[1]){
                return true;
            } else {
                return false;
            }
        }
        //排序
        Arrays.sort(nums);
        //双索引遍历
        int i = 1;
        int j = n - 2;
        int curSum1 = nums[0];
        int curSum2 = nums[n-1];
        while(i <= j){
            if(curSum1 < curSum2){
                curSum1 += nums[i];
                i++;
            } else {
                curSum2 += nums[j];
                j--;
            }
        }
        return curSum1 == curSum2;
    }



    public static void main(String[] args){
        int n = Integer.MIN_VALUE;
        //System.out.println(numOfSquare(18));
        List<String> l = new ArrayList<String>();
        l.add("goy");
        l.add("name");
    }
}
