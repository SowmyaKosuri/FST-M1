package activities;

import java.util.Arrays;

	/* Insertion Sort program - sorting array in ascending order */

public class Activity4 {

	static void ascendingSort(int array[]) {
        int size = array.length;
        int i;
        /*instead of line 9 and 10, you can write like below:
          int size = array.length, i;
         */
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

}
