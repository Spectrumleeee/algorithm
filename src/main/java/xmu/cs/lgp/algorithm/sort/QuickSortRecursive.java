/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.sort;

public class QuickSortRecursive {

    public static void sort(int[] number, int start, int end) {
        if (number == null || start >= end) {
            return;
        }
//        int p = partition1(number, start, end);
        int p = partition2(number, start, end);
        sort(number, start, p - 1);
        sort(number, p + 1, end);
    }

    @SuppressWarnings("unused")
    private static int partition1(int[] number, int start, int end) {
        int pivot = number[start];
        int low = start;
        int high = start + 1;

        for (; high <= end; high++) {
            if (number[high] < pivot) {
                low++;
                swap(number, low, high);
            }
        }
        swap(number, start, low);
        return low;
    }

    private static void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
    
    private static int partition2(int[] number, int start, int end) {
        int pivot = number[start];
        while (start < end) {
            while (start < end && pivot <= number[end])
                end--;
            number[start] = number[end];
            while (start < end && pivot >= number[start])
                start++;
            number[end] = number[start];
        }
        number[start] = pivot;
        
        return start;
    }

    public static void main(String[] args) {
        int[] numberToBeSort = new int[] { 1, 9, 7, 2, 3, 5, 4, 6, 10, 3, 1, 11, 23, 2, 44, 123, 22, 0, 99, 67, 19 };
        QuickSortRecursive.sort(numberToBeSort, 0, numberToBeSort.length - 1);
        for (int i = 0; i < numberToBeSort.length; i++) {
            System.out.print(numberToBeSort[i] + " ");
        }
    }

}
