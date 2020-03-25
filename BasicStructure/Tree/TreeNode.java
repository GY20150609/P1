package BasicStructure.Tree;

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

        //构造方法
        public TreeNode(int _data){
            this.data = _data;
            this.left = null;
            this.right = null;
        }
}
