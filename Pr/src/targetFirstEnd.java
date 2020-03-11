public class targetFirstEnd {

    public static int[] searchRange(int[] nums, int target) {
        //思路
        //前后一起遍历，找到目标值则放入数组中
        int[] res = {-1,-1};
        int i = 0;
        int j = nums.length-1;
        int iflag = -1;
        int jflag = -1;
        while(j - i >= 0 && (iflag < 0 || jflag < 0)) {
            if (iflag < 0){
                if(target == nums[i]) {
                    res[0] = i;
                    iflag = 0;
                    i--;
                }
                i++;
            }
            if (jflag < 0){
                if(target == nums[j]) {
                    res[1] = j;
                    jflag = 0;
                    j++;
                }
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,0};
        System.out.println(searchRange(nums,8)[0]);
    }
}
