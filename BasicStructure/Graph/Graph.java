package BasicStructure.Graph;

import java.util.*;

public class Graph {

    private int nodeNums;
    private Set<Integer> nodes;
    private int[][] eagesMatrix;
    private Map<Integer, List<Integer>> eagesTable;

    public Graph (int n) {
        nodeNums = n;
        nodes = new HashSet<>();
        eagesMatrix = new int[n][n];
        eagesTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
    }

    public Graph (int[][] weight) {
        nodeNums = weight.length;
        nodes = new HashSet<>();
        eagesMatrix = weight;
        eagesTable = new HashMap<>();
        for (int i = 0; i < nodeNums; i++) {
            nodes.add(i);
        }
        matrix2table (weight);
    }

    public Graph (Map<Integer,List<Integer>> table) {
        nodeNums = table.size();
        nodes = table.keySet();
        eagesMatrix = new int[nodeNums][nodeNums];
        table2matrix(table);
        eagesTable = table;
    }

    public void showMatrix () {
        for (int i = 0; i < nodeNums; i++) {
            System.out.println(Arrays.toString(eagesMatrix[i]));
        }
    }

    public void showTable () {
        for (int node : nodes) {
            System.out.println(node + ">>" + eagesTable.get(node));
        }
    }

    public void matrix2table (int[][] array) {
        for (int i = 0; i < nodeNums; i++) {
            int[] temp = array[i];
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nodeNums; j++) {
                if (array[i][j] != 0) {
                    tempList.add(j);
                }
            }
            eagesTable.put(i,tempList);
        }
    }

    public void table2matrix (Map<Integer,List<Integer>> table) {
        for (int i = 0; i < nodeNums; i++) {
            List<Integer> temp = table.get(i);
            for (int indx : temp) {
                eagesMatrix[i][indx] = 1;
            }
        }


    }

    //队列实现
    public void bfs (int node) {
        if (nodes.isEmpty()) {
            System.out.println("图为空！");
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            int currNode = q.poll();
            System.out.print(currNode + " ");
            for (int item : eagesTable.get(currNode)) {
                if (!visited.contains(item)) {
                    q.offer(item);
                    visited.add(item);
                }
            }
        }
        System.out.println();
    }

    //栈实现
    public void dfs (int node) {
        if (nodes.isEmpty()) {
            System.out.println("图为空！");
            return;
        }
        Stack<Integer> s = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        s.push(node);
        visited.add(node);
        while (!s.isEmpty()) {
            int temp = s.pop();
            System.out.print(temp + " ");
            for (int item : eagesTable.get(temp)) {
                if (!visited.contains(item)) {
                    visited.add(item);
                    s.push(item);
                }
            }
        }
        System.out.println();
    }

    //最短路径or路径是否存在-狄克斯特拉（Dijkstra），每次只找价值最大的节点
    //非负加权图
    public void dijkstra (int start,int end){

    }

    public static void main(String[] args) {
        int[][] weight = {
                {0,5,7,0,0,0,2},
                {5,0,0,9,0,0,3},
                {7,0,0,0,8,0,0},
                {0,9,0,0,0,4,0},
                {0,0,8,0,0,5,4},
                {0,0,0,4,5,0,6},
                {2,3,0,0,4,6,0},
        };
        int vecs = weight.length;

        Graph g = new Graph(weight);

        g.bfs(0);
        
        System.out.println(g.eagesTable);

        g.dfs(0);


    } 



}
