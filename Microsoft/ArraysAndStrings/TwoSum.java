package Microsoft.ArraysAndStrings;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2,11,7,15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int [] complIndices = twoSum.getTwoSum(nums, target);
        for(int i : complIndices) System.out.println(i);

    }

    public int[] getTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complMap = new HashMap<>();
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < nums.length; i++){
            //inserting the complemetary value as the key for easier finding and index of it's actual value as value
            //takes care of negitive values as well
            complMap.put((target-nums[i]), i);
        }
        for(int i = 0; i < nums.length; i++){
            if(complMap.containsKey(nums[i])){
                index1 =  i;
                index2 = complMap.get(nums[i]);

                if(index1!=index2) break;
            }
        }

    return new int [] {index1, index2};
    }
}
