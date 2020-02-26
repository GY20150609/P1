package Tree;

/*
顺序存储二叉树
概念：
数组存储和二叉树存储方式可以相互转换

特点： 1.顺序存储二叉树只考虑完全二叉树
       2.第n个元素的左子节点为2*n+1
       3.第n个元素的右子节点为2*n+2
       4.第n个元素的父节点为（n-1）/2
       5.n表示二叉树中的第几个元素（从0开始编号，与数组保持一致）

应用：堆排序
 */

public class ArrayBinaryTree {

    private int[] array;

    public ArrayBinaryTree(int[] arr) {
        this.array = arr;
    }

    //前序遍历方法重载
    public void preSort() {
        this.preSort(0);
    }

    //前序遍历方法重载
    public void infixSort() {
        this.infixSort(0);
    }

    //前序遍历方法重载
    public void postSort() {
        this.postSort(0);
    }

    //顺序存储二叉树前序遍历
    public void preSort(int index) {
        if (this.array == null || this.array.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //打印当前
        System.out.println(this.array[index]);
        //向左遍历
        if (2 * index + 1 < this.array.length) {
            preSort(2 * index + 1);
        }
        //向右遍历
        if (2 * index + 2 < this.array.length) {
            preSort(2 * index + 2);
        }
    }

    //顺序存储二叉树中序遍历
    public void infixSort(int index) {
        if (this.array == null || this.array.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //向左遍历
        if (2 * index + 1 < this.array.length) {
            infixSort(2 * index + 1);
        }
        //打印当前
        System.out.println(this.array[index]);
        //向右遍历
        if (2 * index + 2 < this.array.length) {
            infixSort(2 * index + 2);
        }

    }

    //顺序存储二叉树后序遍历
    public void postSort(int index) {
        if (this.array == null || this.array.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        //向左遍历
        if (2 * index + 1 < this.array.length) {
            postSort(2 * index + 1);
        }
        //向右遍历
        if (2 * index + 2 < this.array.length) {
            postSort(2 * index + 2);
        }
        //打印当前
        System.out.println(this.array[index]);

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.infixSort();
    }
}
