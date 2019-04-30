package Amazon.ArraysAndStrings;

import Google.DynamicProgramming.SentenceScreenFit;

public class SeachPivotArray {

    public static void main(String[] args) {
        SeachPivotArray sp = new SeachPivotArray();
        int[] arr = {4, 5, 6, 7, 8, 9, 0, 1, 2};
        int[] arr2 = {7, 8, 0, 1, 2, 3, 4, 5};
        int[] arr3 = {1, 3};

        System.out.println(sp.search(arr2, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return (nums[0] == target) ? 0 : -1;

        int start = 0;
        int end = nums.length - 1;
//        int mid = (start + end) / 2;
        int mid = 0;
        while (start <= end) {
            mid = (start+ end )/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                } else end = mid - 1;
            } else {
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                } else start = mid + 1;
            }

        }

        return -1;
    }

//    public int search(int[] nums, int target) {
//        int l = 0, r = nums.length-1;
//        while (l <= r) {
//            int m = l + (r-l) / 2;
//            if (nums[m] == target) return m;
//            if (nums[m] < nums[r]) {
//                if (nums[m] < target && target <= nums[r]) l = m+1;
//                else r = m-1;
//            } else {
//                if (nums[l] <= target && target < nums[m]) r = m-1;
//                else l = m+1;
//            }
//        }
//        return -1;
//    }
}
