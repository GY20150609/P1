package Tree;
/*
二叉排序树(二叉搜索树BST) - 高效的“查询”和“插入”
1.概念：
对于二叉排序树的任何一个非叶子节点,要求左子节点的值比当前节点的值小，右子节点的值比当前节点的值大,相等可以放在任意一边;
查找 or 插入 or 删除 -- 类似二分查找，效率较高
使用中序遍历

例：{7，3，10，12，5，1，9}

1.构建排序树
2.中序遍历
3.删除节点
》删除叶子节点{2,5,9,12}
*先找到要删除的节点 target
*找到待删除节点的父节点 parent
*确定target是parent的左子节点还是右子节点
parent.left = null || parent.right = null
》删除只有一颗子树的节点{1}
*先找到要删除的节点 target
*找到待删除节点的父节点 parent
*确定target的子节点是左子节点还是右子节点
*确定target是parent的左子节点还是右子节点
*如果target是parent的左子节点
    *如果target的子节点是左子节点
    parent.left = target.left
    *如果target的子节点是右子节点
    parent.left = target.rigth
*如果target是parent的右子节点
    *如果target的子节点是左子节点
    parent.right = target.left
    *如果target的子节点是右子节点
    parent.right = target.rigth
》删除有2颗子树的节点{7,3,10}
*先找到要删除的节点 target
*找到待删除节点的父节点 parent
*从target的右子树找到最小的节点
*用一个临时变量temp保存最小值
*删除最小节点
*targetNode.value = temp

 */

public class BinarySearchTree {

    private BSTNode head;

    //BST添加
    public void add(BSTNode node) {
        if(head == null){
            head = node;
        } else {
            head.add(node);
        }
    }

    //BST中序遍历
    public void infixShow(){
        if(head == null){
            return;
        }
        this.head.infixShow();
    }

    //BST二分查找目标节点
    public BSTNode Search(int target){
        if(head == null){
            return null;
        }
        return head.Search(target);
    }

    //BST二分查找目标节点的父节点
    public BSTNode SearchParent(int target){
        if(head == null){
            return null;
        }
        return head.SearchParent(target);
    }

    //BST删除目标节点
    public void delete(int data){
        //1.首先找到该节点，判断节点类型（叶子节点、单子树节点、双子树节点）
        if(this.head.data == data){
            this.head = null;
            return;
        }
        BSTNode targetNode = head.Search(data);
        BSTNode parentNode = head.SearchParent(data);
        //若为叶子节点
        if(targetNode.left == null && targetNode.right == null){
            //确定为parent的左子节点还是右子节点
            if(parentNode.left.equals(targetNode)){
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
            return;
        }
        //若为双子树节点，（左右节点其都为null）
        else if(targetNode.left != null && targetNode.right != null){
            //从目标节点的右子树找到最小的节点
            BSTNode minNode = targetNode.right.SearchMin();
            int temp = minNode.data;
            minNode = null;
            targetNode.data = temp;
            return;
        }
        else {
            //目标存在左子树
            if(targetNode.left != null){
                //目标节点在父节点的左
                if(parentNode.left.equals(targetNode)){
                    parentNode.left = targetNode.left;
                } else {
                    parentNode.right = targetNode.left;
                }
            }
            //目标存在右子树
            else {
                //目标节点在父节点的左
                if(parentNode.left.equals(targetNode)){
                    parentNode.left = targetNode.right;
                } else {
                    parentNode.right = targetNode.right;
                }

            }

        }
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        int[] test = {1,2,5,3,4,6};
        for (int i = 0; i < test.length; i++){
            bst.add(new BSTNode(test[i]));
        }
        bst.infixShow();
    }


}

class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                '}';
    }

    //构造方法
    public BSTNode(int _data){
        this.data = _data;
        this.left = null;
        this.right = null;
    }

    //二叉排序规则构建BST
    public void add(BSTNode node){
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

    //中序遍历
    public void infixShow(){
        if(this.left != null){
            this.left.infixShow();
        }
        System.out.print(this.data + " ");
        if(this.right != null){
            this.right.infixShow();
        }
    }

    //中序查找目标节点，并返回当前节点
    public BSTNode infixSearch(int target){
        BSTNode res = null;
        if(this.left != null){
            res = this.left.infixSearch(target);
        }
        if (res != null){
            return res;
        }
        if(this.data == target){
            return this;
        }
        if(this.right != null){
            res = this.right.infixSearch(target);
        }
        return res;
    }

    //目标节点（二分查找）
    public BSTNode Search(int target){
        BSTNode tmpNode = this;
        while(tmpNode != null){
            if(target == tmpNode.data){
                return tmpNode;
            } else if (target > tmpNode.data) {
                tmpNode = tmpNode.right;
            } else {
                tmpNode = tmpNode.left;
            }
        }
        return null;
    }

    //目标节点的父节点（二分查找）
    public BSTNode SearchParent(int target){
        BSTNode tmpNode = this;
        if(this.data == target){
            return null;
        }
        while(tmpNode.left != null || tmpNode.right != null){
            if(tmpNode.left.data == target || tmpNode.right.data == target){
                return tmpNode;
            }
            if(target > tmpNode.data){
                tmpNode = tmpNode.right;
            } else if(target < tmpNode.data){
                tmpNode = tmpNode.left;
            }
        }
        return null;
    }

    //找到最小节点
    public BSTNode SearchMin(){
        BSTNode minNode = this;
        while(minNode.left != null){
            minNode = minNode.left;
        }
        return minNode;
    }
}
