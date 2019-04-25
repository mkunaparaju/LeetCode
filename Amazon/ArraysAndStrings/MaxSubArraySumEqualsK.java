package Amazon.ArraysAndStrings;

public class MaxSubArraySumEqualsK {

    public static void main(String[] args) {

        int [] nums1 = {1, -1, 5, -2, 3};
        int [] nums2 = {-2, -1, 2, 1};

        System.out.println(maxSubArrayLen(nums1,3,0, nums1.length-1));
    }

    public static  int maxSubArrayLen(int[] nums, int k, int remStart, int remEnd) {
//        if (nums.length - remEnd - remStart == 0) return 0;
//        if (nums.length - remEnd - remStart == 1) return (nums[remStart] == k) ? 1 : 0;
////send substring here


        int sum = 0;
        for (int i = remStart; i < remEnd; i++) {
            System.out.print(nums[i] + " ");
            sum += nums[i];
        }

        if (sum == k) return nums.length;
        int sumRemovingStart = sum;
        int sumRemovingEnd = sum;

        sumRemovingStart = sumRemovingStart  - nums[remStart];
        sumRemovingEnd = sumRemovingEnd - nums[nums.length - 1 - remEnd];

        if(sumRemovingEnd == k || sumRemovingStart == k) return nums.length - 1;
        else{
            int remStartLen = maxSubArrayLen(nums, k, remStart+1, remEnd);
            int remEndLen = maxSubArrayLen(nums, k, remStart, remEnd - 1);
            return (remEndLen > remStartLen) ? remEndLen : remStartLen;
        }

    }

}
