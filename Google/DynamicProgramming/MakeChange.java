package Google.DynamicProgramming;

public class MakeChange {
    public static void main(String[] args) {
        int amt = 4;
        int [] denom = {1,2,3};

        System.out.println(ways(amt, denom));
    }

    static int ways(int amt, int [] denom){
        if(amt == 0) return 1;
        if(amt < 0) return 0;

        int ways = 0;
        for(int i = 0; i < denom.length; i++){
            int amtLeft = amt - denom[i];
            ways = ways + ways(amtLeft, denom);
            System.out.println("amtLEFT " + amtLeft+ " ways " + ways);
        }

        return ways;
    }
}
