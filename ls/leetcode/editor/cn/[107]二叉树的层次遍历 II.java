//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==  null){
            return res;
        }
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        //int index = 0;
        while(!qu.isEmpty()){
            int len = qu.size(); //很关键,因为for循环里qu会变,因此不能放在for循环里
            res.add(0,new ArrayList<Integer>());
            for(int i = 0; i < len; i++){
                TreeNode node = qu.remove();
                res.get(0).add(node.val);
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
