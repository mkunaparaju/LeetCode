package Google.DynamicProgramming;

import org.w3c.dom.html.HTMLObjectElement;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int [] arr = {1,2,3,1};
        int []arr2 = {7,1,1,10,1,1,11,12,0,7};
        int [] arr3 = {2,7,9,3,1};

        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(arr));
    }

    public int rob(int[] nums) {
//        return robSimple(nums, 0);
//        int [] vals = new int [nums.length+1];
//        Arrays.fill(vals, -1);
//        return robMemo(nums,0, vals);

//        return robSimpleDp(nums);
//        return robCircleDp(nums, 1, nums.length - 1);
        return Math.max(robCircleDp(nums,0,nums.length - 2),robCircleDp(nums, 1, nums.length - 1)) ;
    }

    private int robCircleDp(int[] nums, int index, int end) {
        if(nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];
        int [] dp = new int [nums.length + index];
        dp[index] = 0;
        dp[index + 1] = nums[index];

        for(int i = index + 1; i <= end; i++){
            dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
        }

        return dp[end + 1];
    }


    private int robSimpleDp(int [] nums){
        if(nums.length == 0 ) return 0;
        int [] dp = new int [nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
        }

        return dp[nums.length];
    }

    private int robMemo(int[] nums, int index, int [] vals) {
        if(index == nums.length - 1) return nums[index];
        if(index > nums.length - 1) return 0;

        if(vals[index] != -1) return vals[index];

        int v1 = nums[index] + robMemo(nums,index+2, vals);
        int v2 = nums[index+1] + robMemo(nums,index+3,vals);
        //int v2 = robMemo(nums,index + 1,vals);
        vals[index] =Math.max(v1,v2);

        return vals[index];
    }

    private int robSimple(int[] nums, int index) {
        if(index == nums.length - 1) return nums[index];
        if(index > nums.length - 1) return 0;

        int v1 = nums[index] + robSimple(nums,index+2);
        int v2 = nums[index+1] + robSimple(nums,index+3);

        return Math.max(v1, v2);

    }






}
