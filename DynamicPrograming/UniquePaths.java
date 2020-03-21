package DynamicPrograming;
/*
题目：
给点m行n列的网格，有一个机器人从左上角（0，0）出发，每一步可以向下或者向右走一步
问有多少种不同的方式走到右下角
思路：
计数型动态规划+考虑加法转移
1.确定状态
》最后一步：
向右或者向下，右下角坐标(m-1,n-1)
》子问题：
最后一步前一步肯定是在(m-2,n-1)或(m-1,n-2)
那么如果机器人有X种方式从左上角走到(m-2,n-1),有Y种方式从左上角走到(m-1,n-2)，则机器人有X+Y种方式走到(m-1,n-1)
问题转换为>>机器人有多少种方式从左上角走到(m-2,n-1)和(m-1,n-2)
》状态
设stage[i][j]为机器人有多少种方式从左上角走到(i,j)
2.转移方程
stage[i][j] = stage[i-1][j]+stage[i][j-1]
3.初始条件和边界情况
stage[0][0] = 1;
i = 0 | j = 0 则前一步只能有一个方向过来 stage[i][j] = 1
4.计算顺序
计算第一行：stage[0][0],stage[0][1]...
计算第二行：stage[1][0],stage[1][1]...n
...
计算第n行：stage[n][0],stage[n][1]...

 */

public class UniquePaths {

    public static int Solution(int m,int n){
        //初始化状态数组
        int[][] stage = new int[m][n];
        // 初始条件和边界情况
        //stage[0][0] = 0;
        /*
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    stage[i][j] = 1;
                }
            }
        }
         */
        //计算顺序
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //边界条件另一种写法，[0,0]初不初始化其实不重要，后面没用到
                if(i == 0 || j ==0){
                    stage[i][j] = 1;
                } else{
                    //状态转移方程
                    stage[i][j] = stage[i-1][j] + stage[i][j-1];
                }
            }
        }
        return stage[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(Solution(3,3));
    }
}
