//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


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
class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    //迭代写法
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        int index = 0; //代表层数
        Queue<TreeNode> qu = new LinkedList<TreeNode>(); //队列存储每列节点
        qu.add(root);
        while(!qu.isEmpty()){
            int quLen = qu.size(); //记录队列长度
            res.add(new ArrayList<Integer>());
            for(int i = 0; i < quLen; i++){
                TreeNode node = qu.remove();
                //添加当前节点
                res.get(index).add(node.val);
                //将当前节点的左右节点加到队列
                if(node.left != null){
                    qu.add(node.left);
                }
                if(node.right != null){
                    qu.add(node.right);
                }
            }
            index++;
        }
        return res;
    }


    //递归写法
    /*

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        helper(root,0);
        return res;
    }

    public void helper(TreeNode node,int level){
        //判断当前level与res的size是否相等,相等就创建空list
        if(level == res.size()){
            res.add(new ArrayList<Integer>());
        }
        //添加当前元素到list
        res.get(level).add(node.val);
        //判断左子节点是否为空
        if(node.left != null){
            helper(node.left,level+1);
        }
        if(node.right != null){
            helper(node.right,level+1);
        }
    }

     */
}
//leetcode submit region end(Prohibit modification and deletion)
