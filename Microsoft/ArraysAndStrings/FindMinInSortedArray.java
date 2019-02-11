package Microsoft.ArraysAndStrings;

public class FindMinInSortedArray {

    public static void main(String[] args) {
        int [] arr = {8,9,10,11,5,6,7};
        int [] arr1 = {3,4,5,1,2};
        int [] arr2 = {3,1,2};

        FindMinInSortedArray fm = new FindMinInSortedArray();
        System.out.println(fm.findMin(arr));
    }

    public int findMin(int[] nums) {
        if (nums.length ==0) return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid = (start+end)/2;

        while(start < end){
            if(nums[start] < nums[end]) return nums[start];
            else{
                if(nums[start] <= nums[mid]){
                    start = mid + 1;
                    mid = (start+end)/2;
                }
                else{
                    end = mid;
                    mid = (start+end)/2;
                }
            }
        }
return nums[mid];
    }
}
