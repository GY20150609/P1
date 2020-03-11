public class addTwoNum {
    public static int addNoOperator(int a,int b,int count){
        count++;
        if (a > 0){
            a--;
            return addNoOperator(a,b,count);
        }
        if (b > 0){
            b--;
            return addNoOperator(a,b,count);
        }
        return count - 1;
    }

    public static int addNoOperator(int a,int b) {
        int tmp1 = a^b;
        int tmp2 = (a&b)>>1;
        //if (tmp2 == 0) {
        //
        //}
        System.out.println(tmp1);
        System.out.println(tmp2);
        return 1;
    }

    public static void main(String[] args){
        System.out.println(addNoOperator(3,2));
    }
}
