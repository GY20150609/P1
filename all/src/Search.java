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

    public static int BinarySearchRec(int[] nums,int target,int left,int right){
        if (left > right){
            return left;
        }
        int mid = left + (right - left)/2;
        if(target > nums[mid]){
            return BinarySearchRec(nums,target,mid+1,right);
        } else if(target < nums[mid]) {
            return BinarySearchRec(nums,target,left,mid-1);
        } else if (target == nums[mid]){
            return mid;
        }
        return -1;
    }

    public static int InsertSearch(int[] nums,int target){
        if (nums.length == 1 && nums[0] != target){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(right >= left) {
            int mid = left + (right - left) * (target - nums[0])/(nums[nums.length - 1] - nums[0]);
            if (target > nums[mid]) {
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]){
                return mid;
            }
        }
        return -1;
    }

    public static int LeftBoundSearch(int[] nums, int target){
        if (nums.length == 1 && nums[0] != target){
            return -1;
        }
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

    public static int LeftBoundSearchRec(int[] nums,int target,int left,int right){
        if(left > right){
            return left;
        }
        int mid = left + (right - left)/2;
        if(target > nums[mid]){
            return LeftBoundSearchRec(nums,target,mid+1,right);
        } else if(target < nums[mid]){
            return LeftBoundSearchRec(nums,target,left,mid-1);
        } else if (target == nums[mid]){
            return LeftBoundSearchRec(nums,target,left,mid-1);
        }
        return -1;
    }

    public static int RightBoundSearch(int[] nums, int target){
        if (nums.length == 1 && nums[0] != target){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(right >= left){
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] == target){
                // 收缩左边界
                left = mid + 1;
            }
        }
        // 是否越界或最后一个元素不等于目标值
        if (right >= nums.length || nums[right] != target){
            return -1;
        }
        return right;
    }

    public static int[] LeftRightBoundSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        int[] res = {-1,-1};

        return res;
    }


    public static void main(String[] args) {
        int[] array = {1,2,8,8,8,9,10};
        System.out.println(LeftBoundSearchRec(array,9,0,array.length-1));
    }
}
