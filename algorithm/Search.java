package algorithm;

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
            return -1;
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

    public static int InsertSearchRec(int[] nums,int target,int left,int right){
        int mid = left + (right - left)*(target - nums[0])/(nums[nums.length-1] - nums[0]);
        if (target > nums[mid]) {
            return InsertSearchRec(nums,target,mid+1,right);
        } else if (target < nums[mid]){
            return InsertSearchRec(nums,target,left,mid-1);
        } else if (target == nums[mid]) {
            return mid;
        }
        return -1;
    }

    public static int FibSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int index = 0;
        int length = nums.length;
        // 1. 初始化fib数列
        int[] fib = Fib(10);
        // 2. 找到刚好可以包含右边界长度的数列值
        while(right + 1 > fib[index]){
            index++;
        }
        int[] tmpData = new int[fib[index] - 1];
        //3. 比较数组长度与找到的数列值，若数组长度小于数列值，则用末尾元素补齐数组（长度与数列值一致）
        for (int j = 0; j < fib[index] - 1; j++){
            if (j > length - 1){
                tmpData[j] = nums[length - 1];
            } else {
                tmpData[j] = nums[j];
            }
        }
        //4. 黄金比例分割当前数组
        while(right >= left){
            mid = left + fib[index - 1] - 1;
            if (target < tmpData[mid]){
                right = mid - 1;
                index = index - 1;
            }else if(target > tmpData[mid]){
                left = mid + 1;
                index = index -2;
            } else if(target == tmpData[mid]){
                return mid > length - 1 ? mid - 1 : mid;
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

    public static int RightBoundSearchRec(int[] nums, int target,int left,int right){
        if (left > right){
            return right;
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]) {
            return RightBoundSearchRec(nums, target,mid+1,right);
        } else if (target < nums[mid]){
            return RightBoundSearchRec(nums, target,left,mid-1);
        } else if (target == nums[mid]){
            return RightBoundSearchRec(nums, target,mid+1,right);
        }
        return -1;
    }

    public static int[] LeftRightBoundSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int[] res = {-1,-1};
        int flag = BinarySearchRec(nums,target,left,right);
        if (flag != -1){
            res[0] = LeftBoundSearchRec(nums,target,left,right);
            res[1] = RightBoundSearchRec(nums,target,left,right);
        }
        return res;
    }

    public static int[] Fib(int maxSize){
        int[] res = new int[maxSize];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < maxSize; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(FibSearch(array,7));
    }
}
