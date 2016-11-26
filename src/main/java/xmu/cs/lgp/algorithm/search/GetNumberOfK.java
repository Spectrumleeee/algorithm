/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.search;

/**
 * 剑指Offer --- 38.统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class GetNumberOfK {

    public int getNumberOfK(int[] numbers, int length, int k) {
        int number = 0;
        
        int firstKIndex = getFirstK(numbers, length, k, 0, length -1);
        int lastKIndex = getLastK(numbers, length, k, 0, length -1);
        
        if (firstKIndex > 0 && lastKIndex > 0) {
            number = lastKIndex - firstKIndex + 1;
        }
        
        return number;
    }
    
    private int getFirstK(int[] numbers, int length, int k, int start, int end) {
        if (numbers == null || length <= 0 ) {
            throw new RuntimeException();
        }
        
        if (start > end) {
            return -1;
        }
        
        int middle = (start + end) /2;
        int middleData = numbers[middle];
        
        if (middleData == k) {
            if(middle == 0 || (middle > 0 && numbers[middle -1] != k)) {
                return middle;
            }
            else {
                end = middle - 1;
            }
        }
        else if (middleData > k) {
            end = middle - 1;
        }
        else {
            start = middle + 1;
        }
        
        return getFirstK(numbers, length, k, start, end);
    }
    
    private int getLastK(int[] numbers, int length, int k, int start, int end) {
        if (numbers == null || length <= 0 ) {
            throw new RuntimeException();
        }
        
        int middle = (start + end) / 2;
        int middleData = numbers[middle];
        
        if (middleData == k) {
            if ( middle == length - 1 || (middle < length - 1 && numbers[middle + 1] != k)) {
                return middle;
            }
            else {
                start = middle + 1;
            }
        }
        else if (middleData < k) {
            start = middle + 1;
        }
        else {
            end = middle -1;
        }
        
        return getLastK(numbers, length, k, start, end);
    }
    
    public static void main(String[] args) {
        GetNumberOfK testCase = new GetNumberOfK();
        int numbers[] = new int[] {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,5,6,7};
        int k = 5;
        
        System.out.println(testCase.getNumberOfK(numbers, numbers.length, k));
    }

}
