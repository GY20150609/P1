package BasicStructure.Tree;

/*
线索二叉树
1.n个节点的二叉树中含有n+1个空指针域，利用各个节点的空指针域（左or右节点为null）,存放指向该节点在某种遍历次序下的前驱和后继节
  点的指针；
2.加了线索的二叉链表——线索链表，加了线索的二叉树——线索二叉树（Threaded Solution.BinaryTree），根据线索性质不同分为前序线索二叉树、中序
  线索二叉树、后序线索二叉树；
3.一个节点某种次序的前一个节点，称为前驱节点；
4.一个节点某种次序的后一个节点,称为后继节点；

二叉树 >> 遍历方式 >>线索化二叉树
 */

public class ThreadBinaryTree {

    private threadNode root;
    private threadNode pre;

    public ThreadBinaryTree(threadNode root) {
        this.root = root;
        this.pre = null;
    }

    // 线索化二叉树
    public void thread() {

    }

}

// 线索节点
class threadNode {
    private int id;
    private threadNode left;
    private threadNode right;
    private int leftType;
    private int rightType;
    private threadNode pre = null;


    public threadNode(int id) {
        this.id = id;
    }

    // 中序线索化节点(结合中序遍历后的结果容易理解)
    public void thread(threadNode node) {
        if (node == null) {
            System.out.println("此树为空");
            return;
        }
        // 向左子树遍历
        thread(node.left);
        //线索化当前节点
        //1.处理前驱节点
        if (node.left == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //2.处理后驱节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //向右子树遍历
        thread(node.right);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public threadNode getLeft() {
        return left;
    }

    public void setLeft(threadNode left) {
        this.left = left;
    }

    public threadNode getRight() {
        return right;
    }

    public void setRight(threadNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public threadNode getPre() {
        return pre;
    }

    public void setPre(threadNode pre) {
        this.pre = pre;
    }
}
