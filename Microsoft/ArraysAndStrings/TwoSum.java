package Microsoft.ArraysAndStrings;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2,11,7,15};
        int [] nums1 = {3,2,4};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int [] complIndices = twoSum.twoSum(nums1, 6);
        for(int i : complIndices) System.out.println(i);

    }

//    public int[] getTwoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> complMap = new HashMap<>();
//        int index1 = -1;
//        int index2 = -1;
//        for(int i = 0; i < nums.length; i++){
//            //inserting the complemetary value as the key for easier finding and index of it's actual value as value
//            //takes care of negitive values as well
//            complMap.put((target-nums[i]), i);
//        }
//        for(int i = 0; i < nums.length; i++){
//            if(complMap.containsKey(nums[i])){
//                index1 =  i;
//                index2 = complMap.get(nums[i]);
//
//                if(index1!=index2) break;
//            }
//        }
//
//    return new int [] {index1, index2};
//    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numSet = new HashMap<Integer, Integer>();

        for(int i =0; i < nums.length; i++) {
            numSet.put(nums[i], i);
        }

        int [] out = new int [2];
        for(int i = 0 ; i < nums.length; i++){
         //   System.out.println(nums[i]);
            if(numSet.containsKey(target-nums[i]) ){
                if(i == numSet.get(target-nums[i])) continue;;

                out[0] = i;
                out[1] = numSet.get(target-nums[i]);


                break;
            }
        }
        return out;
    }
}
