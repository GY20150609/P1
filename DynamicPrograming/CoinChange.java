package DynamicPrograming;

/*
题目：
》有三种硬币，分别为2，5，7元面值，每种硬币都有足够多
》买一本书需要27元
》如何用最少的硬币组合正好付清，不需要对方找钱

思路：
最大最小值型动态规划+考虑min|max转移
1.确定状态
》最后一步(最优策略中使用的最后一枚硬币Ak)
》化成子问题(最少的硬币拼出更小的面值27-Ak)
》状态(设stage[i]为拼出i所需要的最少硬币数)
2.转移方程
》f[X] = min{f[X-2]+1,f[x-5]+1,f[x-7]+1} 代表拼出X所需要的最小硬币数
3.初始条件和边界情况
》f[0] = 0
》如果不能拼出Y，f[Y]=正无穷
4.计算顺序
f[0] f[1] f[2],...

 */

public class CoinChange {

    public static int Solution(int[] A, int goal){
        int coinNums = A.length;
        int[] stage = new int[goal+1]; //状态数组，索引X代表拼出X所需最少硬币数
        stage[0] = 0; //初始状态
        //计算顺序,子问题逐步求解原问题
        for(int i = 1; i <= goal; ++i){
            stage[i] = Integer.MAX_VALUE;
            //最后一步，可能的情况遍历
            for(int j = 0; j< coinNums; ++j){
                //确定边界情况
                if(i >= A[j] && stage[i - A[j]]!=Integer.MAX_VALUE){
                    //状态转移方程
                    stage[i] = Math.min(stage[i-A[j]]+1,stage[i]);
                }
            }
        }
        if(stage[goal] == Integer.MAX_VALUE){
            return -1;
        }
        return stage[goal];
    }

    public static void main(String[] args){
        int[] a = {1,2,5};
        int goal = 11;
        System.out.println(Solution(a,goal));
    }
}
