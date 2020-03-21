package DynamicPrograming;

/*
题目:
有n块石头分别在x轴的0，1，...，n-1位置
一只青蛙在石头0,想跳到石头n-1
如果青蛙在第i块石头上，它最多可以向右跳距离ai
问青蛙能否跳到石头n-1

例：
a[2,3,1,1,4] 输出True
a[3,2,1,0,4] 输出False

思路：
可行性动态规划

1.确定状态
》最后一步《
如果青蛙能跳到n-1,考虑它跳的最后一步
这一步从石头i跳过来,i<n-1
需要同时满足两个条件：
1.青蛙可以跳到石头i
2.最后一步不超过跳跃的最大距离：n-1-i<= a[i]
》子问题《
需要知道青蛙能不能跳到石头i(i<n-1)
》状态《
设stage[j]表示青蛙能不能跳到石头j

2.转移方程
枚举上一个跳到的石头i
stage[j] = OR(0<=i<j)(stage[i] AND i+a[i]>=j)

3.初始状态和边界情况
stage[0] = True

4.计算顺序
从左往右依次计算


 */

public class JumpGame {

    public static boolean Solution(int[] arr){
        //初始化状态
        int length = arr.length;
        boolean[] stage = new boolean[length];
        stage[0] = true;
        //计算顺序
        for(int j = 1;j < length; j++){

            //转移方程
            //[0,j)之间有没有石头i可以跳到j
            for(int i = 0; i < j; i++){
                if(stage[i] && i + arr[i] >= j){
                    stage[j] = true;
                    break;
                } else {
                    stage[j] = false;
                }
            }
        }
        return stage[length-1];
    }

    public static void main(String[] args){
        System.out.println(Solution(new int[] {3,2,1,0,4}));
    }
}
