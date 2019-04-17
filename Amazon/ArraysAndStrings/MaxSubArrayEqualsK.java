package Amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

public class MaxSubArrayEqualsK {
    public static void main(String[] args) {

        int nums[] = {1, -1, 5, -2, 3};
        int nums1[] = {-2, -1, 2, 1};
        int nums2[] = {3};

        MaxSubArrayEqualsK m = new MaxSubArrayEqualsK();

        System.out.println(m.maxSubArrayLen(nums, 3));
//        System.out.println(m.maxSubArrayLen(nums1, 1));

    }

//    public int maxSubArrayLen(int[] nums, int k) {
//        HashMap<String, Integer> numMap = new HashMap<>();
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        return maxSubArrayLen(nums, k, 0, nums.length, numMap, sum);
//    }

    private int maxSubArrayLen(int[] nums, int k, int startIndex, int endIndex, HashMap<String, Integer> numMap, int origSum) {
//        System.out.println("start " + startIndex + " end " + endIndex);
        String lookUpKey = startIndex + " " + endIndex;
        if (numMap.containsKey(lookUpKey)) return numMap.get(lookUpKey);
        int lengthOfRemArray = endIndex - startIndex;

        if (lengthOfRemArray == 0) return 0;
        if (lengthOfRemArray == 1) {
            if (nums[startIndex] == k) return 1;
            else return 0;
        }

//        int sum = 0;
//        for (int i = startIndex; i < endIndex; i++) {
//            sum += nums[i];
//        }
//        System.out.println("sum " + sum);

        if (origSum == k) {
            numMap.put(lookUpKey, lengthOfRemArray);
            return lengthOfRemArray;
        } else {
            int max1 = Math.max(maxSubArrayLen(nums, k, startIndex, startIndex + 1, numMap, nums[startIndex]),
                    maxSubArrayLen(nums, k, startIndex + 1, endIndex, numMap, origSum - nums[startIndex]));

            int max2 = Math.max(maxSubArrayLen(nums, k, startIndex, endIndex - 1, numMap, origSum - nums[endIndex - 1]),
                    maxSubArrayLen(nums, k, endIndex - 1, endIndex, numMap, nums[endIndex - 1]));

            int finalMax = (max1 > max2) ? max1 : max2;
            numMap.put(lookUpKey, finalMax);
            return finalMax;
        }
    }

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if(numsMap.containsKey(sum-k)){
                //sum(currIndex) - sum(prevIndex) = k
                //implies: sum(curr) - k = sum(prev)
                //We keep track of all the sums at prev index and retreive the index
                //current index - prev Index = length (subArraySum = k)
                //Keep track of all those lengths and get the max of them.
                max = Math.max(max, i - numsMap.get(sum-k));
            }
            if(!numsMap.containsKey(sum)) numsMap.put(sum, i);
        }
        return max;
    }
}
