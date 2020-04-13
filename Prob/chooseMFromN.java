package Prob;

import java.util.Arrays;
import java.util.Random;

public class chooseMFromN {

    public static int[] chooseMFromN (int[] nums ,int m) {
        int[] res = new int[m];
        int n = nums.length;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            //生成[0,n-1]之间随机数
            if(i < m) {
                res[i] = nums[i];
            } else {
                int rNum = r.nextInt(n-1);
                if(rNum <= m) {
                    res[rNum] = nums[i];
                }
            }
        }
        return res;
    }

    public static void main (String[] args) {
        int[] d = {1,2,3};
        for (int i = 0; i < 100; i++){
            System.out.println(Arrays.toString(chooseMFromN(d,2)));
        }

    }
}
