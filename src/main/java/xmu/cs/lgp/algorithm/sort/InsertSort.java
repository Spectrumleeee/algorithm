/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-12-25
 */

package xmu.cs.lgp.algorithm.sort;

public class InsertSort {

    public static void sort(int[] a, int start, int end) {
        for (int i = 1; i <= end; i++) {
            int pivot = a[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if (a[j] > pivot) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = pivot;
        }
    }
    
    public static void main(String[] args) {
        int[] numberToBeSort = new int[] { 1, 9, 7, 2, 3, 5, 4, 6, 10, 3, 1, 11, 23, 2, 44, 123, 22, 0, 99, 67, 19 };
        InsertSort.sort(numberToBeSort, 0, numberToBeSort.length - 1);
        for (int i = 0; i < numberToBeSort.length; i++) {
            System.out.print(numberToBeSort[i] + " ");
        }
    }

}
