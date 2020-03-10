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


    public static int LeftBoundSearch(){

        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1,3,5,7,8};
        System.out.println(BinarySearch(array,7));
    }
}
