//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        int index = 0; //代表层数
        Queue<TreeNode> qu = new LinkedList<TreeNode>(); //队列存储每列节点
        qu.add(root);
        while(!qu.isEmpty()){
            res.add(new ArrayList<Integer>());
            int len = qu.size();
            for(int i = 0; i < len; i++){
                TreeNode node = qu.remove();
                if(index % 2 == 0){
                    res.get(index).add(node.val);
                } else{
                    res.get(index).add(0,node.val);
                }

                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
            index++;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
