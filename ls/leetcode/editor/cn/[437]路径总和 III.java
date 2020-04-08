//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
总的路径数 = 根节点为起始点的路径数 + 左子树中节点为起始点的路径数 + 右子树中节点为起始点的路径数
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        //根节点为起始点的路径数,每次遍历逗得减去上一个节点的值
        int rootNum = pathHelper(root,sum);
        //左子树中节点为起始点的路径数
        int leftNum = pathSum(root.left,sum);
        //右子树中节点为起始点的路径数
        int rightNum = pathSum(root.right,sum);

        return rootNum + leftNum + rightNum;
    }

    //返回当前节点为起始节点的路径和,sum为当前剩余值
    public int pathHelper(TreeNode node,int sum){
        if(node == null){
            return 0;
        }
        int res = 0;
        if(node.val == sum){
            res++;
        }
        res += pathHelper(node.left,sum-node.val);
        res += pathHelper(node.right,sum-node.val);

        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
