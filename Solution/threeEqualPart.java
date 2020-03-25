package Solution;

public class threeEqualPart {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int length = A.length;
        boolean flag = true;
        for(int m = 0; m < length; m++) {
            sum += A[m];
        }
        if (sum%3 != 0) {
            return false;
        }
        int i = 0;
        int j = length - 1;
        while(j - i > 1 && flag){
            if (sum1 != sum/3){
                sum1 += A[i];
                i++;
            }
            if (sum2 != sum/3){
                sum2 += A[j];
                j--;
            }
            if (sum1 == sum/3 && sum2 == sum/3){
                flag = false;
            }
        }
        if (flag == false){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] A = {1,0,2,-6,-7,7,9,2,0,1};
        System.out.println(canThreePartsEqualSum(A));
    }
}
