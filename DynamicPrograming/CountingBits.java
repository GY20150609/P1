package DynamicPrograming;

/*
输入N 输出0，1，2，3，4...N二进制中1的个数
要求：时间复杂度O(N),空间复杂度O(1)

例： N = 3
output = [0,1,1,2]
 */

import java.util.Arrays;

public class CountingBits {

    public static int[] Solution (int N) {
        int[] stage = new int[N+1];
        int i;
        stage[0] = 0;
        for (i = 1; i <= N; i++) {
            stage[i] = stage[i>>1] + i % 2;
        }
        return stage;
    }

    public static void main (String[] args) {
        int[] res = Solution(3);
        System.out.println(Arrays.toString(res));
    }


}
