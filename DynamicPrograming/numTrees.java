package DynamicPrograming;
/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

思路：典型的代码简单规律难，需要借助中间函数构建转移方程
1.确定状态
》最后一步
【1，2，3...n】节点集合以n为根节点不同结构的二叉树
》子问题
【1，2，3...n-1】节点集合以n-1为根节点不同结构的二叉树
》状态数组
最终数组：stage[i]表示i个节点集合不同结构二叉树的数量（其实【1，2，3】 与 【3，4，5】二叉搜索数数量是一样的，不关乎具体数值大小）
2.转移方程
中间数组：f[j]表示以j为根节点不同结构二叉树的个数
则 stage[i] = f[1] + f[2] + f[3] + ... + f[i]
当以j为根节点时，【1,2,3...,j-1】共j-1个节点组成左子树 【j+1,j+2,...,n】共n-j个节点组成右子树
则f[j] = stage[j-1] * stage[i-j] 两边子树两两组合，要么右子树在左子树右下，要么右上
3.初始条件和边界条件
stage[0] = 1 stage[1] = 1
4.计算顺序
 */

public class numTrees {
    public int Solution(int n){
        int[] stage = new int[n+1];
        stage[0] = 1;
        stage[1] = 1;
        //依次以i为节点个数
        for(int i = 2; i <= n; i++){
            //在i个节点中，依次以j（属于集合【1，2，... i】）为根节点
            for(int j = 1; j <= i; j++){
                //f[i] = stage[j-1]*stage[i-j] j-1个节点的左子树 i-j个节点的右子树
                stage[i] += stage[j-1]*stage[i-j];
            }
        }
        return stage[n];
    }
}
