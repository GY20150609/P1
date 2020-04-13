package algorithm;

public class QuickPow {

    //递归写法
    public static int QRecPow(int base, int n) {
        //结束条件
        if( n == 0) {
            return 1;
        }
        //偶数幂
        else if(n % 2 == 0) {
            int temp = QRecPow(base,n/2);
            return temp * temp;
        }
        //奇数幂
        else {
            return QRecPow(base,n-1) * base;
        }
    }

    //位运算写法
    public static int QBitePow(int base, int n) {
        int res = 1;
        int newBase = base;
        if(n == 0) {
            return 1;
        }
        //判断二级制最后一位是否为1
        while(n > 0){
            if((n & 1) == 1) {
                res = res * newBase;
            }
            newBase *= newBase;
            n = n >> 1;
        }
        return res;
    }

    public static void main (String[] args) {
        System.out.println(QBitePow(2,5));
    }
}
