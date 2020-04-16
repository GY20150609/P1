package DynamicPrograming.序列型;

/*
有N栋房子，用红黄蓝三种颜色去粉刷，每栋房子用三种颜色粉刷的费用都不一样
要求：1.相邻房子颜色不能一样  2.总花费最小

例：
Input: [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class paintHouse {

    public static int Solution(List<List<Integer>> costs) {

        int n = costs.size();
        int[][] stage = new int[n+1][3];
        for (int i = 0; i < 3; i++) {
            stage[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            stage[i][0] = Math.min(stage[i-1][1],stage[i-1][2]) + costs.get(i-1).get(0);
            stage[i][1] = Math.min(stage[i-1][0],stage[i-1][2]) + costs.get(i-1).get(1);
            stage[i][2] = Math.min(stage[i-1][0],stage[i-1][1]) + costs.get(i-1).get(2);
        }

        return Math.min(Math.min(stage[n][0],stage[n][1]),stage[n][2]);

    }

    public static void main(String[] args) {
        int[][] res = {{14,2,11},{11,14,5},{14,3,10}};
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < res.length; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < res[0].length; j++){
                temp.add(res[i][j]);
            }
            data.add(temp);
        }
        System.out.println(Solution(data));
    }
}
