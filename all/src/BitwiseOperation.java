public class BitwiseOperation {
    // 1. “&” 运算符
    /*
    1 & 1 = 1
    1 & 0 = 0
     */

    // 2. “|”运算符
    /*
    1 | 1 = 1
    1 | 0 = 0
     */

    // 3. “^”运算符
    /*
    1 ^ 1 = 0
    0 ^ 0 = 0
    1 ^ 0 = 1
    结论： n ^ n = 0      n ^ 0 = n
     */
    // 数组中数都出现两次，只有一个数出现一次，找到该数
    public static int findSingleNum(int[] array){
        int res = 0;
        for (int i = 0; i < array.length; i++){
            res ^= array[i];
        }
        return res;
    }

    // 4. “<<”左移运算符
    /*
    0001<<1 = 0010
    结论：等价于*2
     */

    // 5. “>>”右移运算符
    /*
    1000>>1 = 0100
    结论：等价于/2
     */

    public static void main(String[] args){
        int[]  arr = {1,1,2,2,3};
        System.out.println(findSingleNum(arr));
    }

}
