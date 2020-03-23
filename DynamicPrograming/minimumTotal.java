package DynamicPrograming;
/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

import java.util.*;

public class minimumTotal {

    public static void display(int[][] vv) {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int Solution(ArrayList<ArrayList<Integer>> arr){
        int row = arr.size();
        int len = arr.get(row - 1).size();
        //stage[i][j]表示到达i行第j个节点的最短路径
        int[][] stage = new int[len][len];
        //初始化
        stage[0][0] = arr.get(0).get(0);
        //计算顺序，下一行依赖前一行
        for (int i = 1; i < row; i++){
            for(int j = 0; j < arr.get(i).size(); j++){
                //转移方程

                if(j == 0){
                    stage[i][j] = stage[i-1][0] + arr.get(i).get(j);
                } else if(j == arr.get(i).size() - 1){
                    stage[i][j] = stage[i-1][arr.get(i).size() - 2] + arr.get(i).get(j);
                } else {
                    stage[i][j] = Math.min(stage[i-1][j/2]+arr.get(i).get(j),stage[i-1][j/2+1]+arr.get(i).get(j));
                }
            }
        }
        display(stage);
        return 0;
    }

    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp1 = new ArrayList<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp1.add(new Integer(2));
        res.add(0,tmp1);
        tmp2.add(new Integer(3));
        tmp2.add(new Integer(4));
        res.add(1,tmp2);
        System.out.println(Solution(res));
    }

}
