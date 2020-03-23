package DynamicPrograming;
/*
最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

思路：
到达右下角无非下移和右移，每次转移的时候比较下和右即可
stage[i][j] [0,0]-[i,j]的最短路径之和
 */
public class shortestDis {

    public static void display(int[][] vv) {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int minPathSum(int[][] stage) {
        //状态数组
        int m = stage.length;
        int n = stage[0].length;
        int sum1 = 0;
        int sum2 = 0;
        //第一行初始化
        for(int i=0;i<n;i++){
            stage[0][i] += sum1;
            sum1 = stage[0][i];
        };
        //第一列初始化
        for(int i=0;i<m;i++){
            stage[i][0] += sum2;
            sum2 = stage[i][0];
        }
        //初始条件
        for(int i =1;i<m;i++){
            for(int j=1;j<n;j++){
                stage[i][j] = Math.min(stage[i-1][j] + stage[i][j],stage[i][j-1]+stage[i][j]);
            }

        }

        return stage[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(test));
    }
}
