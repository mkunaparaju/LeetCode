package Amazon.ArraysAndStrings;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] in1 = {1, 2, 3, 4};
        int[] in2 = {};

        ProductOfArrayExceptSelf pa = new ProductOfArrayExceptSelf();
        int[] out = pa.productExceptSelf(in1);

        for (int i : out) {
            System.out.println(i + " ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        out[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {

            out[i] = out[i + 1] * nums[i + 1];
            System.out.print(out[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < nums.length; i++) {
            out[i] = nums[i-1] * out[i];
            nums[i] = nums[i] * nums[i-1];
            System.out.print(out[i] + " ");
        }

        return out;

    }
}

