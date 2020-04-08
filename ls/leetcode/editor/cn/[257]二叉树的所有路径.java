//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


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

    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return res;
        }
        String s = "";
        binaryTreePathsHelper(root,s);
        return res;
    }

    public void binaryTreePathsHelper(TreeNode node,String s){
        if(node == null){
            return;
        }
        if(s.equals("")){
            s += node.val;
        } else {
            s = s + "->" + node.val;
        }
        if(node.left == null && node.right == null){
            res.add(s);
            s = s.substring(0,s.length()-1);
        }
        binaryTreePathsHelper(node.left,s);
        binaryTreePathsHelper(node.right,s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
