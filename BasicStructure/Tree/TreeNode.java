package BasicStructure.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                '}';
    }

    public void add(TreeNode node){
        if(node.data > this.data){
            if(this.right !=null){
                this.right.add(node);
            } else {
                this.right = node;
            }
        } else if(node.data <= this.data) {
            if(this.left != null){
                this.left.add(node);
            } else {
                this.left = node;
            }
        }
    }

    //构造方法
    public TreeNode(int _data){
        this.data = _data;
        this.left = null;
        this.right = null;
    }

    //返回左子树的深度
    public int subLeftTree () {
        if(left == null){
            return 0;
        }
        return left.nodeDepth();
    }

    //返回右子树的深度
    public int subRightTree () {
        if(right == null){
            return 0;
        }
        return right.nodeDepth();
    }

    //返回当前节点为根节点的子树深度
    public int nodeDepth () {
        return Math.max(left == null ? 0 : left.nodeDepth(),right == null ? 0 : right.nodeDepth()) + 1;
    }

    //层序遍历
    public void levelSort() {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(this);
        while(!qu.isEmpty()) {
            int len = qu.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = qu.poll();
                System.out.print(node.data + " ");
                if(node.left != null){
                    qu.offer(node.left);
                }
                if(node.right != null){
                    qu.offer(node.right);
                }
            }
        }
        System.out.println();
    }

    //左旋
    public void leftRotate() {
        TreeNode newNode = new TreeNode(this.data);
        newNode.left = this.left;
        if(this.right != null) {
            newNode.right = this.right.left;
            this.data = this.right.data;
            this.left = newNode;
            this.right = this.right.right;
        }
    }


}
