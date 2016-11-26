/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.search;

/**
 * 剑指Offer --- 8.输入一个递增排序数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class MinOfWhirlyArray {

    public int Min(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            throw new RuntimeException();
        }
        
        if (length == 1) {
            return numbers[0];
        }
        
        int start = 0;
        int end = length -1;
        int middle = start;
        while(numbers[start] >= numbers[end]) {
            if(end - start == 1) {
                middle = end;
                break;
            }
            
            middle = (start + end) / 2;
            if (numbers[middle] >= numbers[start]) {
                start = middle;
            } else if (numbers[middle] <= numbers[end]) {
                end = middle;
            }
        }
        
        return numbers[middle];
    }
    
    public static void main(String[] args) {
        MinOfWhirlyArray testCase = new MinOfWhirlyArray();
        
        int whirlyArray[] = new int[]{3,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,7,8,9,1,2};
        
        int minValue = testCase.Min(whirlyArray, whirlyArray.length);
        
        System.out.println("Min: " + minValue);
        
    }

}
