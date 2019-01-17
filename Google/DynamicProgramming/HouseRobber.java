package Google.DynamicProgramming;

import org.w3c.dom.html.HTMLObjectElement;

public class HouseRobber {

    public static void main(String[] args) {
        int [] arr = {1,2,3,1};
        int []arr2 = {7,1,1,10,1,1,11,12,0,7};

        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(arr2));
    }


    public int rob(int[] nums) {
        return rob(nums, 0, false);

    }

    private int rob(int[] nums, int index, boolean used) {
        if(index > nums.length - 1) return 0;
        if(index == nums.length - 1) return used? 0 : nums[index];
        int robbedValue = 0;
        if(index != nums.length -2) {
            robbedValue = Math.max(nums[index] + rob(nums, index +2, true), nums[index+1] + rob(nums, index+3, false));
        }else{
            robbedValue = Math.max(nums[index] + rob(nums, index +2, true), nums[index+1] + rob(nums, index+3, false));
        }

        System.out.println("index " + index + " val " + robbedValue);
        return robbedValue;
    }
}
