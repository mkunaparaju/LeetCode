package Google.ArraysStrings;

public class TrapWater {

    public static void main(String[] args) {
        TrapWater tw = new TrapWater();
        int [] ar = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] ar2 = {2,0,2};
        int [] ar3 = {4,2,3};
        System.out.println(tw.trap(ar3));
    }

    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        //point here is :
        int [] left = new int [height.length];
        int right [] = new int [height.length];
        int max = height[0];;
        left[0] = height [0];
        for(int i = 1; i <  height.length ; i++){
            if(max <= height[i]){
                max = height[i];
                left[i] = height[i];
            }
            else {
                left[i] = max;
            }
        }

        right[height.length -1] = height[height.length -1];
        max = height[height.length-1];
        for(int i = height.length - 2; i>=0; i--){
            if(height[i] < max){
                right[i] = max;
            }
            else{
                right[i] = height[i];
                max = height[i];
            }
        }

        int res = 0;

        for(int i = 0; i < height.length; i++){

            res+= Math.min(left[i], right[i]) - height[i];
        }
    return res;
    }

}
