public class demo {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if( m == 0 || n ==0){
            return 0;
        }
        int tmpMax = Integer.MIN_VALUE;
        int[][] stage = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    stage[i][j] = matrix[i][j] - 48;
                }else if(matrix[i][j] == '1'){
                    stage[i][j] = Math.min(Math.min(stage[i-1][j],stage[i][j-1]),stage[i-1][j-1]) + 1;
                }
                tmpMax = tmpMax < stage[i][j] ? stage[i][j] : tmpMax;
            }
        }
        return tmpMax*tmpMax;
    }

    public static void main(String[] args){
        int n = Integer.MIN_VALUE;
        String s = "112";
        char[][] ss = {{'1'}};
        System.out.println(maximalSquare(ss));
    }
}
