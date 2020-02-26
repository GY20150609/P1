public class BagSolution {

    private int c = 4;
    private int[] v = {1500,2000,3000};
    private int[] w = {1,3,4};
    private int[][] vv;

    public BagSolution(int num) {
        vv = new int[num + 1][c + 1];
        for (int i = 0; i < c + 1; i++) {
            vv[0][i] = 0;
        }
        for (int j = 0; j < num + 1; j++){
            vv[j][0] = 0;
        }
    }

    public void display() {
        for (int i = 0; i < vv.length; i++){
            for (int j = 0; j < vv[0].length; j++){
                System.out.print(vv[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve() {
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= v.length; j++){
                if (w[j-1] >= i) {
                    vv[j][i] = v[j-1];
                } else {
                    vv[j][i] = Math.max(vv[j-1][i],v[j-1]+vv[j-1][i-w[j-1]]);
                }
            }
        }
    }

    public static void main(String[] args) {
        BagSolution b = new BagSolution(3);
        b.display();
        b.solve();
        System.out.println("After");
        b.display();
    }
}
