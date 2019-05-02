package Google.ArraysStrings;

import java.util.Arrays;

public class KEmptySlots {
/*
n slots
n flowers
flower []  1......n
position [] 1......n
n days


 */


    public static void main(String[] args) {
        KEmptySlots kes = new KEmptySlots();
        int [] flowers = {1,3,2};
        int k = 1;
        System.out.println(kes.kEmptySlots(flowers, k));
    }

    public int kEmptySlots(int[] flowers, int k) {

        boolean [] position = new boolean [flowers.length];
        Arrays.fill(position,false);

        for(int i = 0; i < flowers.length; i++) {
            int slot = flowers[i] - 1;
//            System.out.println("slot " + slot);
//            System.out.println(position[slot]);
            position[slot] = true;

            int start = slot - k - 1;
            int end = slot + k +1;

            System.out.println("startslot " + start + " endslot " + end);
            boolean startCheck = false;
            if (start >= 0 && position[start]) {
//                startCheck = true;
                for (int j = start+1; j < slot; j++) {
//                    System.out.println("j " + j);
                    if (position[j]) {
                        startCheck = false;
                        break;
                    } else {
                        startCheck = true;
                    }
                }
            }


            boolean endCheck = false;
            if (end < position.length && position[end]) {
                for (int j = slot + 1; j < end; j++) {
//                    System.out.println("j " + j + position[j]) ;
                    if (position[j]) {
                        startCheck = false;
                        break;
                    } else startCheck = true;
                }
            }

            if (startCheck || endCheck) return i + 1;
        }
        return -1;

    }
}
