package Microsoft.SortAndSearch;

public class SortColors {
    public void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length -1;
        int count = 0;
        while(start < end){
            int temp = nums[count];
            nums[count++] = 1;

            if(temp == 0){
                nums[start++] = 0;
            }
            if(temp == 2) {
                nums[count] = nums[end];
                count --;
                nums[end] = 2;
                end --;
            }
        }
    }
}
