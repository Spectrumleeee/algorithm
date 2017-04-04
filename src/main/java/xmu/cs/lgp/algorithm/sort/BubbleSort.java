/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-12-25
 */

package xmu.cs.lgp.algorithm.sort;

public class BubbleSort {
    
    public static void sort(int[] a, int start, int end) {
        for (int i = end; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j+1] < a[j]) {
                    swap(a, j+1, j);
                }
            }
        }
    }
    
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numberToBeSort = new int[] { 1, 9, 7, 2, 3, 5, 4, 6, 10, 3, 1, 11, 23, 2, 44, 123, 22, 0, 99, 67, 19 };
        BubbleSort.sort(numberToBeSort, 0, numberToBeSort.length - 1);
        for (int i = 0; i < numberToBeSort.length; i++) {
            System.out.print(numberToBeSort[i] + " ");
        }
    }

}
