public class Search {

    public static int BinarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(right>=left){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static int LeftBoundSearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    public static void main(String[] args) {
        int[] array = {1,3,5,7,8};
        System.out.println(LeftBoundSearch(array,8));
    }
}
