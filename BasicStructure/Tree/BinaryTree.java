package BasicStructure.Tree;

/*
树
概念：节点、根节点、父节点、子节点、叶子节点、节点的权、路径、层、子树、树的高度、森林

二叉树
概念：每个节点至多两个子节点

满二叉树
概念：二叉树的所有叶子节点都在最后一层，并且节点总数=2^n-1，n为层数

完全二叉树
概念：所有叶子节点都在最后一层或者倒数第二层、而且最后一层的叶子节点在左边连续、倒数第二层的叶子节点在右边连续

前序遍历：
先输出父节点、再遍历左子树和右子树

中序遍历：
先遍历左子树、再输出父节点、再遍历右子树

后序遍历：
先遍历左子树、再遍历右子树，再输出父节点

*可以根据父节点的顺序判断是哪种遍历方式

 */

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class BinaryTree {
    private node root;

    public void setRoot(node root) {
        this.root = root;
    }

    //前序遍历
    public void preSort() {
        if (this.root != null) {
            this.root.preSort();
        } else {
            System.out.println("The Tree Is Empty!");
        }
    }

    //前序查找
    public node preSearch(int no) {
        if (root != null) {
            return root.preSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历
    public void infixSort() {
        if (this.root != null) {
            this.root.infixSort();
        } else {
            System.out.println("The Tree Is Empty!");
        }
    }

    //中序查找
    public node infixSearch(int no) {
        if (root != null) {
            return root.infixSearch(no);
        }else {
            return null;
        }
    }

    //后序遍历
    public void postSort() {
        if (this.root != null) {
            this.root.postSort();
        } else {
            System.out.println("The Tree Is Empty!");
        }
    }

    //后序查找
    public node postSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        }else {
            return null;
        }
    }

    //层级遍历
    //队列先进先出，依次把每个节点的左右节点push到队列
    public void levelSort(){
        Queue<node> q = new ArrayDeque<node>();
        q.add(this.root);
        while (!q.isEmpty()){
            node tmp = q.poll();
            if(tmp != null){
                System.out.println(tmp.toString());
                if(tmp.getLeft() != null){
                    q.add(tmp.getLeft());
                }
                if(tmp.getRight() != null){
                    q.add(tmp.getRight());
                }
            }
        }
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getData() == no) {
                root = null;
            }else {
                root.delNode(no);
            }
        } else {
            System.out.println("此树为空");
        }
    }

    //按规则删除节点
    public void delRuleNode(int no) {
        if (root != null) {
            if (root.getData() == no) {
                root = null;
            }else {
                root.delRuleNode(no);
            }
        }
    }

    //统计节点个数
    public int numNodes(){
        if(this == null){
            return 0;
        }
        return this.root.numNodes();
    }

    //深度
    public int depth(){
        if(this == null){
            return 0;
        }
        return this.root.depth();
    }

    //叶子节点个数
    public int numLeafNode(){
        if(this == null){
            return 0;
        }
        return this.root.numLeafNode();
    }

    //k层节点个数
    public int kLevelNumNode(int k){
        if(this == null || k < 1){
            return 0;
        }
        return this.root.kLevelNumNodes(k);
    }

    //是否平衡二叉树
    public boolean isAVL(){
        if(this == null){
            return false;
        }
        return this.root.isAVL()>-1?true:false;
    }

    //判断两个二叉树是否相同
    public boolean isSame(node newNode){
        return this.root.isSame(newNode);
    }



    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        node root = new node("爷爷",0);
        node node1 = new node("爸爸",1);
        node node2 = new node("妈妈",2);
        node node3 = new node("女儿",4);
        node node4 = new node("儿子",5);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node4);
        node2.setRight(node3);
        tree.setRoot(root);
        //System.out.println("删除节点后");
        //tree.preSort();
        tree.levelSort();
        System.out.println(tree.isSame(tree.root));
    }
}

class node {
    private String name;
    private int data;
    private node left;
    private node right;

    public node(String name,int data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "node{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    //前序遍历
    public void preSort() {
        System.out.println(this.toString());
        if (this.left != null) {
            this.left.preSort();
        }
        if(this.right != null) {
            this.right.preSort();
        }
    }

    //前序查找
    public node preSearch(int no) {
        node resNode = null;
        // 判断当前节点是否等于查找值，若等于直接返回
        System.out.println("进入前序查找！");
        if (this.data == no) {
            return this;
        }
        // 否则，判断左节点是否为空，若不为空则向左遍历
        if (this.left != null) {
            resNode = this.left.preSearch(no);
        }
        // 判断向左遍历是否找到，若找到直接返回
        if (resNode != null) {
            return resNode;
        }
        // 若向左遍历未找到，则判断右节点是否为空后继续向右遍历
        if(this.right != null) {
            resNode = this.right.preSearch(no);
        }
        return resNode;
    }

    //中序遍历
    public void infixSort() {
        if (this.left != null) {
            this.left.infixSort();
        }
        System.out.println(this.toString());
        if(this.right != null) {
            this.right.infixSort();
        }
    }

    //中序查找
    public node infixSearch(int no) {
        node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixSearch(no);
        }
        //判断左递归是否找到
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找！");
        if(this.data == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixSearch(no);
        }
        return resNode;
    }

    //后序遍历
    public void postSort() {
        if (this.left != null) {
            this.left.postSort();
        }
        if(this.right != null) {
            this.right.postSort();
        }
        System.out.println(this.toString());
    }

    //后序查找
    public node postSearch(int no) {
        node resNode = null;
        if(this.left != null) {
            resNode = this.left.postSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        if(this.right != null) {
            resNode = this.right.postSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入后序查找！");
        if (this.data == no) {
            return this;
        }
        return null;
    }

    //删除节点
    public void delNode(int no) {
        // 判断当前节点子节点是否为空，并且是否等于待删除编号
        if (this.left != null && this.left.data == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.data == no) {
            this.right = null;
            return;
        }
        // 向左递归
        if (this.left != null) {
            this.left.delNode(no);
        }
        //向右递归
        if (this.right != null) {
            this.right.delNode(no);
        }
        return;
    }

    //左节点或唯一节点补齐
    public void delRuleNode(int no) {
        if (this.left != null && this.left.getData() == no) {
            if (this.left.left == null && this.left.right == null) {
                this.left = null;
                return;
            }
            if (this.left.left != null) {
                this.left = this.left.left;
                return;
            }
            if (this.left.right != null && this.left.left == null) {
                this.left = this.left.right;
                return;
            }
        }
        if (this.right != null && this.right.getData() == no) {
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
                return;
            }
            if (this.right.left != null) {
                this.right = this.right.left;
                return;
            }
            if (this.right.right != null && this.right.left == null) {
                this.right = this.right.right;
                return;
            }
        }
        if (this.left != null) {
            this.left.delRuleNode(no);
        }
        if (this.right != null) {
            this.right.delRuleNode(no);
        }
    }

    //节点数
    public int numNodes(){
        int left = 0;
        int right = 0;
        //左子树节点个数
        if(this.left != null){
            left = this.left.numNodes();
        }
        //右子树节点个数
        if(this.right != null){
            right = this.right.numNodes();
        }
        return 1 + left + right;
    }

    //深度
    public int depth() {
        int left = 0;
        int right = 0;
        //左子树最大深度
        if (this.left != null) {
            left = this.left.depth();
        }
        //右子树最大深度
        if (this.right != null) {
            right = this.right.depth();
        }
        return 1 + Math.max(left, right);
    }

    //叶子节点个数
    public int numLeafNode(){
        int left = 0;
        int right = 0;
        if(this.left == null && this.right == null){
            return 1;
        }
        if(this.left != null){
            left = this.left.numLeafNode();
        }
        if(this.right != null){
            right = this.right.numLeafNode();
        }
        return left + right;
    }

    //第k层得节点数
    public int kLevelNumNodes(int k){
        int l = 0;
        int r = 0;
        if(this == null && k < 1) {
            return 0;
        }
        if(k==1){
            return 1;
        }
        if(this.left != null){
            l = this.left.kLevelNumNodes(k-1);
        }
        if(this.right != null){
            r = this.right.kLevelNumNodes(k-1);
        }
        return l + r;
    }

    //判断以当前节点为根节点的两个子二叉树是否平为衡二叉树
    //二叉树的每个节点的左右两个子树的高度差的绝对值不超过1。
    public int isAVL(){
        int l = 0;
        int r = 0;
        if(this == null){
            return 0;
        }
        //利用现有递归求取深度，避免不必要的开销
        if(this.left != null){
            l = this.left.isAVL();
        }
        if(this.right != null){
            r = this.right.isAVL();
        }
        if(l == -1 || r == -1 || Math.abs(l-r) > 1){
            return -1;
        }
        return Math.max(l,r)+1;
    }

    //判断以当前节点为根节点的两个子二叉树是否相同
    public boolean isSame(node newNode){
        if(this == null && newNode == null){
            return true;
        } else if(this == null || newNode == null){
            return false;
        }
        if(this.data == newNode.data){
            return true;
        }
        boolean l = this.left.isSame(newNode.left);
        boolean r = this.right.isSame(newNode.right);
        if(l && r){
            return true;
        }
        return false;
    }
}

