package Solution;

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

    public static int[] searchRange_v1(int[] nums, int target) {
        // 思路
        // 二分查找是否存在目标值
        // 👈边界查找
        // 右边界查找
        int last = nums.length - 1;
        int[] res = {-1,-1};
        int l_indx = LeftBinarySearch(nums,target,0,last);
        if (l_indx != -1){
            res[0] = l_indx;
            res[1] = RightBinarySearch(nums,target,0,last);
            return res;
        }
        return res;
    }

    public static int LeftBinarySearch(int[] nums,int target,int left,int right){
        if (left > right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]){
            return LeftBinarySearch(nums,target,mid+1,right);
        } else if (target < nums[mid]){
            return LeftBinarySearch(nums,target,left,mid-1);
        } else if (target == nums[mid]){
            return LeftBinarySearch(nums,target,left,mid-1);
        }
        return -1;
    }

    public static int RightBinarySearch(int[] nums,int target,int left,int right){
        if (left > right){
            return right;
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]){
            return RightBinarySearch(nums,target,mid+1,right);
        } else if (target < nums[mid]){
            return RightBinarySearch(nums,target,left,mid-1);
        } else if (target == nums[mid]){
            return RightBinarySearch(nums,target,mid+1,right);
        }
        return -1;
    }


    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,0};
        System.out.println(LeftBinarySearch(nums,5,0,5));
    }
}
