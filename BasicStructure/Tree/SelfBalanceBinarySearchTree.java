package BasicStructure.Tree;

/*
平衡二叉树（平衡二叉搜索树，AVL）

*用途 ：保证查询效率较高
*提出背景 ： 二叉搜索树在所有元素递增时，退化为链表结构，查找效率低于单链表
*特点 ： 为一棵空树或者它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
*常用实现方法 ： 红黑树、AVL、替罪羊树、Treap、伸展树等
*如何提升效率了 ？ >> 关键是将非平衡二叉树转化为平衡二叉树
*如何转化了？   >> 左旋转|右旋转，其实就是将深度较大的子树的节点往深度较小的子树上移，
                减小深度较大子树的深度

 */

public class SelfBalanceBinarySearchTree {

    private TreeNode root;

    public void add (TreeNode node) {
        if(root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    public void levelSort () {
        if(root == null){
            return;
        }
        root.levelSort();
    }

    public int getRightDepth () {
        if(root == null) {
            return 0;
        }
        return root.subRightTree();
    }

    public int getLeftDepth () {
        if(root == null) {
            return 0;
        }
        return root.subLeftTree();
    }

    public void leftRotate () {
        if(root == null) {
            return;
        }
        root.leftRotate();
    }




    public static void main (String[] args) {
        int[] arr = {4,3,6,5,7,8};
        SelfBalanceBinarySearchTree avlTree = new SelfBalanceBinarySearchTree();
        for(int i = 0; i < arr.length; i++) {
            avlTree.add(new TreeNode(arr[i]));
        }
        avlTree.levelSort();
        avlTree.leftRotate();
        avlTree.levelSort();

    }
}
