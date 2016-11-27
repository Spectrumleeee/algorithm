/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.sort;

public class QuickSort {
    
    public static void sort(int[] number, int start, int end) {
        if (number == null || start >= end) {
            return;
        }
        
        int x = number[end];
        int low=start, high=start;
        for(; high<end; high++) {
            if (number[high] < x) {
                swap(number, low++, high);
            } 
        }
        
        swap(number, low, end);
        
        sort(number, start, low-1);
        sort(number, low+1, end);
    }
    
    private static void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numberToBeSort = new int[]{1,9,7,2,3,5,4,6,10,3,1,11,23,2,44,123,22,0,99,67,19};
        QuickSort.sort(numberToBeSort, 0, numberToBeSort.length - 1);
        for (int i=0; i<numberToBeSort.length; i++) {
            System.out.print(numberToBeSort[i] + " ");
        }
    }

}
