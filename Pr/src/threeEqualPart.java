public class threeEqualPart {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        int length = A.length;
        boolean flag = true;
        for(int m = 0; m < length; m++) {
            sum += A[m];
        }
        int p_sum = sum%3;
        if (p_sum != 0) {
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
        for (int k = i; k <= j; k++){
            sum3 += A[k];
        }
        if (sum3 == sum/3){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        canThreePartsEqualSum(A);
    }
}
