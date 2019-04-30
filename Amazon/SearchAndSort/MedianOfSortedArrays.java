package Amazon.SearchAndSort;

public class MedianOfSortedArrays {

    public static void main(String[] args) {

        int[] n1 = {1};
        int[] n2 = {1};

        MedianOfSortedArrays ms = new MedianOfSortedArrays();
        System.out.println(ms.findMedianSortedArrays(n1, n2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        int in1 = 0;
        int in2 = 0;
        int i = 0;
        while (in1 < nums1.length || in2 < nums2.length) {
            if (in1 == nums1.length) {
                nums[i] = nums2[in2];
                i++;
                in2++;
                continue;
            }
            if (in2 == nums2.length) {
                nums[i] = nums1[in1];
                i++;
                in1++;
                continue;
            }

            if(nums1[in1] <= nums2[in2]){
                nums[i] = nums1[in1];
                i++;
                in1++;
                continue;
            }

            if(nums1[in1] > nums2[in2]){
                nums[i] = nums2[in2];
                i++;
                in2++;
                continue;
            }
        }
//        System.out.println(nums.length);
//        System.out.println(nums.length%2 == 0);
//        System.out.println((nums[nums.length/2] + nums[nums.length/2 - 1])/2);
        return (nums.length%2 == 0)? (double)(nums[nums.length/2] + nums[nums.length/2 - 1])/2 : nums[nums.length/2];

    }

}
