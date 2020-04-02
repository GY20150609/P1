//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        sortHelper(root,res);
        return res;
    }

    public static void sortHelper(TreeNode root,List<Integer> res){
        if(root.left != null) {
            sortHelper(root.left, res);
        }
        res.add(root.val);
        if(root.right != null){
            sortHelper(root.right,res);
        }
    }

    public static void sortIter(TreeNode root,List<Integer> res){
        //左遍历
        while(root.left != null){

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
