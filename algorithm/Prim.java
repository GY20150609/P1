package algorithm;/*
普利姆算法(Prim)-村庄修路问题
场景：有7个村庄(A,B,C,D,E,F,G),现在需要修路将7个村庄联通，各个村庄的距离用边线表示(权)
问题: 如何修路保证各个村庄都能联通，并且总的修建公路总里程最短
思路：尽可能选择少的路线，并且每条路线最短，进而保证总里程最短
 */


import java.util.Arrays;

public class Prim {

    Graph graphMeta;

    public Prim(int _vecs,char[] _data,int[][] _weigth){
        graphMeta = new Graph(_vecs);
        graphMeta.vecs = _vecs;
        graphMeta.data = _data;
        graphMeta.weight = _weigth;

    }

    public void look(int index){
        int numNodes = graphMeta.vecs;
        int numEdges = graphMeta.vecs - 1;
        int[] visited = new int[numNodes];
        int minDis;
        //保存已访问节点索引
        int h1 = -1;
        //保存未访问节点索引
        int h2 = -1;
        visited[index] = 1;

        //需要找到n-1个边，每次遍历找到最短的边
        for(int i = 1; i < numNodes; i++){
            minDis = 10000;

            //遍历已访问的点
            for(int m = 0; m < numNodes; m++){
                //遍历未访问的点
                for(int n = 0; n < numNodes; n++){
                    //判断m点是否已访问，判断n点是否未访问
                    if(visited[m] == 1 && visited[n] == 0 && minDis > graphMeta.weight[m][n]){
                        minDis = graphMeta.weight[m][n];
                        h1 = m;
                        h2 = n;
                    }
                }
            }
            System.out.println(graphMeta.data[h1] + ">" + graphMeta.data[h2] + " " + minDis);
            visited[h2] = 1;
        }
    }

    public static void main(String[] args){

        int num = 7;
        char[] node = {'A','B','C','D','E','F','G'};
        int[][] neiWeight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        Prim p = new Prim(num,node,neiWeight);
        p.look(1);

    }

}

class Graph{
    //顶点个数
    int vecs;
    //顶点内容
    char[] data;
    //邻接矩阵
    int[][] weight;

    public Graph(int _vecs){
        this.vecs = _vecs;
        this.data = new char[_vecs];
        this.weight = new int[_vecs][_vecs];
    }

    public void show(){
        for (int i = 0; i < weight.length; i++){
            System.out.println(Arrays.toString(weight[i]));
        }
    }
}


