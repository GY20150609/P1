package algorithm.knn;

public class KDTree {


}

class KDNode {
    //指定按i维度进行分支
    private int partitionIndex;
    //按i维度的中值进行分支
    private double[] partitionValue;
    //左分支
    private KDNode left;
    //右分支
    private KDNode right;
    //是否叶子节点
    private boolean isLeaf;
    //该节点包含数据集i维度的最大值
    private double[] max;
    //该节点包含数据集i维度的最小值
    private double[] min;
}