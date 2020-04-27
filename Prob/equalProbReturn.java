package Prob;

import java.util.Random;

public class equalProbReturn {

    //某个生成器以概率p返回0，以1-p概率返回1
    //要求设计另一个生成器以等概率返回0和1
    public static int randomSys1 (float p) {
        Random r = new Random();
        int res = r.nextInt(10);
        if (res < 10 * p) {
            return 0;
        }
        return 1;
    }

    public static int randomSys2 (float p) {
        while (true) {
            int num1 = randomSys1(p);
            int num2 = randomSys1(p);
            if (num1 == 0 && num2 == 1) {
                return 0;
            }
            if (num1 == 1 && num2 == 0) {
                return 1;
            }
        }

    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(randomSys2(0.2f));
        }

    } 
}
