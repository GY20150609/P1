package algorithm;


/*
牛顿迭代法
https://www.bbsmax.com/A/qVde1X68dP/

f(x) = x^m - num

迭代公式:

 */
public class QuickSqrt {

    public static double qsqrt (double num) throws Exception{
        if (num < 0) {
            throw new Exception("Number must be larger than 0");
        }
        if (num == 0) {
            return 0;
        }
        //f(x) = x^2 - num
        //找到使f(x) = 0 的零点xt
        double x = 1.0; //初始值
        double err = 1e-6;
        double tmp;
        while (true) {
            tmp = x * x;
            if (Math.abs(num - tmp) <= err) {
                return x;
            }
            x = x - (tmp - num) / (2 * x);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(qsqrt(10));
        } catch (Exception e) {
            System.out.println("Wrong!");
        }

    }
}
