package Microsoft.ArraysAndStrings;

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] arr2 = {0,2,0};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int volume = 0;
        int p1 = 0;
        int p2 = 1;

        while(p1<height.length && p2 < height.length){
            if(height[p2] <= height[p1]){
//                System.out.println("p2 " + p2 );
                int temp = p2;
                while(temp < height.length - 1){
                    //System.out.println("temp " + temp);
                    if(height[temp] >= height[p1]){
                        volume += calculateVolume(height, p1, p2);
                    }
                    temp++;
                }
                if(temp < height.length -1) {
                    p2 = temp;
                }


//                System.out.println("vol " +  volume);
//                System.out.println("heighTep " + height[temp] + "heip2 " + height[p2]);
            }

            p1 = p2;
            p2++;
        }

        return volume;
    }

    private static int calculateVolume(int[] height, int p1, int p2) {
        if(p2 == 0 ) return 0;
        int volume = 0;
        if(p1+1 != p2) {
            if(height[p1] < height[p2]) height[p2] = height[p1]; else height[p1] = height[p2];
        }
        while(p1  < p2 ){
            volume = volume + Math.abs(height[p1] - height[p1+1]);
            p1++;
        }
        return volume;
    }
}
