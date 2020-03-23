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
}
