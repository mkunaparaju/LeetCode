package Amazon.ArraysAndStrings;

public class FindDuplicate {

    public static void main(String[] args) {
        int [] arr = {3,1,3,4,2};
        FindDuplicate dupe= new FindDuplicate();

        System.out.println(dupe.findDuplicate(arr));
    }

    public int findDuplicate(int[] nums) {
        

    }


//    //easy soln worng soln formultiple dupes ofsame number
//    public int findDuplicate(int[] nums) {
//        int length = nums.length;
//        int n = length - 1;
//
//        int sumOfN = (n*(n+1))/2;
//        int actualSum = 0;
//
//        for(int i : nums){
//            actualSum += i;
//        }
//
//        System.out.println("actual " + actualSum);
//        System.out.println("sumofN " + sumOfN);
//        return actualSum-sumOfN;
//    }
}
