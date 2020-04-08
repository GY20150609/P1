import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo {

    List<List<Integer>> result;

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

    public static int numSquares(int n) {
        if( n <= 3){
            return n;
        }
        int[] stage = new int[n+1];
        stage[0] = 0;
        stage[1] = 1;
        stage[2] = 2;
        for(int i = 3; i <= n; i++){
            int tmpMin = i;
            int maxVal = (int)Math.floor(Math.sqrt(i));
            for(int j = 1; j <= maxVal; j++){
                tmpMin = Math.min(tmpMin,stage[i-j*j]+1);
            }
            stage[i] = tmpMin;
        }
        return stage[n];
    }



    public static boolean divisorGame(int N) {
        if (N == 1){
            return false;
        }
        boolean[] stage = new boolean[N+1];
        stage[1] = false;
        stage[2] = true;
        for(int i = 3; i <= N; i ++){
            int index = 1;
            while(index < i){
                //Alice选index之后,判断stage[i-index]能不能赢，
                if(i % index == 0 && !stage[i - index]){
                    stage[i] = true;
                    break;
                } else {
                    stage[i] = false;
                }
                index++;
            }
        }
        return stage[N];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        //遍历顺序很重要，从后往前遍历
        int n = s.length();
        boolean[] stage = new boolean[n+1];
        stage[0] = true;
        String res1 = "";
        String res2 = "";
        for(int i = 0; i < n; i++){
            res1 = res1 + s.charAt(i);
            res2 = res2 + s.charAt(i);
            for(String item : wordDict){
                if(res2.equals(item) || res1.equals(item) && stage[i - res1.length() + 1]){
                    stage[i+1] = true;
                    res1 = "";
                    break;
                }
            }
        }
        return stage[n];

    }

    public static void main(String[] args){
        int n = Integer.MIN_VALUE;
        List<String> table = new ArrayList<String>();
        table.add("aaaa");
        table.add("aaa");
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.clear();
        String ss = "111";
        Stack<Integer> s = new Stack<Integer>();
        s.isEmpty()




        //System.out.println(numSquares(18));
        System.out.println(res);
    }
}
