package Google.ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int [] ar = {9,6,4,2,3,5,7,0,1};
        System.out.println(mn.missingNumber(ar));
    }

    public int missingNumber(int[] nums) {
        int [] aux = new int [nums.length + 1];
        Arrays.fill(aux, -1);
        for(int i = 0; i < nums.length ; i++){
            aux[nums[i]] = 1;
        }
        int missing = -1;

        for(int i = 0 ; i< aux.length ;i++){
            if(aux[i] == -1) missing = i;
        }

        return missing;
    }

    private int missingNumberAlt(int []nums){
        int sum = nums.length * (nums.length + 1) / 2;

        for(int i = 0; i < nums.length; i++)
            sum -= nums[i];

        return sum;
    }
}
