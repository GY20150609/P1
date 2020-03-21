package DynamicPrograming;

/*
题目：
背包容量为4，现要依次装入多个物品，使总价值最大
书-1500,吹风机-2000,电脑3000 s[]
各个物品容量，书-1,吹风机-3,电脑-4 w[]

思路：
最大最小值型动态规划-max
1.确定状态
》最后一步
最优策略,最后放入物品i(w[i],s[i]),装满4容量背包价值最大
》子问题
放入物品i之前，装满4 - w[i]容量的背包价值最大
》状态
设stage[i][j]为放入第i个物品装满j容量的背包最大价值

2.转移方程
stage[i][j] = max(stage[i-1][j],stage[i-1][j-w[i]]+w[i])

3.初始条件和边界情况
i = 0 | j = 0 stage[i][j]=0
剩余容量 > 物品i容量

4.计算顺序
一行一行来
 */

public class BagProblem {

    public static void display(int[][] vv) {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Solution(int[] w,int[] s,int c){
        int itemNum = w.length;
        //初始化状态数组
        int[][] stage = new int[itemNum + 1][c+1];
        for(int i = 0; i <= itemNum; i++){
            for(int j = 0; j <= c; j++){
                if(i == 0 || j ==0){
                    stage[i][j] = 0;
                } else {
                    if(j > w[i-1]){
                        stage[i][j] = Math.max(stage[i-1][j],s[i-1]+stage[i-1][j - w[i-1]]);
                    } else if (j == w[i-1]) {
                        //放不下
                        stage[i][j] = s[i-1];
                    } else if(j < w[i-1]){
                        stage[i][j] = 0;
                    }
                }
            }
        }

        display(stage);
    }

    public static void main(String[] args){
        int[] s = {6500,2000,3000};
        int[] w = {3,3,4};
        Solution(w,s,4);
    }
}
