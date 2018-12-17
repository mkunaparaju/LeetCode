package Arrays;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */

import java.util.Scanner;

public class RemoveDuplicatesInArray {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++)    {
            array[i] = scanner.nextInt();
        }
        array = removeDuplicatesInPlace(array);
        printArray(array);
    }

    private static int[] removeDuplicatesInPlace(int[] array) {
        int [] finalArray = new int [array.length];
        int index = 0;
        for(int i = 0; i < array.length; i++)   {
            
        }
        return null;
    }

    private static void printArray(int [] array)    {

    }

}
