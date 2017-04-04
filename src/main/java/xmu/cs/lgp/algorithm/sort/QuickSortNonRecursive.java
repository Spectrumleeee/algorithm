/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-12-25
 */

package xmu.cs.lgp.algorithm.sort;

import java.util.Stack;

public class QuickSortNonRecursive {
    
    public static void sort(int[] number, int start, int end) {
        if (number == null || start >= end) {
            return;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(end);
        stack.push(start);
        
        while(!stack.isEmpty()) {
            int l = stack.pop();
            int r = stack.pop();
            int p = partition2(number, l, r);
            
            if (l < p - 1) {
                stack.push(p - 1);
                stack.push(l);
            }
            
            if (r > p + 1) {
                stack.push(r);
                stack.push(p + 1);
            }
        }
    }
    
    public static int partition1(int[] number, int start, int end) {
        int pivot = number[start];
        
        int low = start;
        int high = start + 1;
        
        for(; high <= end; high++){
            if (number[high] < pivot) {
                low++;
                swap(number, low, high);
            }
        }
        swap(number, start, low);
        return low;
    }
    
    public static int partition2(int[] number, int start, int end) {
        int pivot = number[start];
        
        while(start < end) {
            while(start < end && number[end] >= pivot) 
                end--;
            number[start] = number[end];
            
            while(start < end && number[start] < pivot) 
                start++;
            number[end] = number[start];
        }
        number[start] = pivot;
        return start;
    }
    
    public static void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numberToBeSort = new int[] { 1, 9, 7, 2, 3, 5, 4, 6, 10, 3, 1, 11, 23, 2, 44, 123, 22, 0, 99, 67, 19 };
        QuickSortNonRecursive.sort(numberToBeSort, 0, numberToBeSort.length - 1);
        for (int i = 0; i < numberToBeSort.length; i++) {
            System.out.print(numberToBeSort[i] + " ");
        }
    }

}
