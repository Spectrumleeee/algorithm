/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.recursion;
/**
 * 剑指Offer --- 12.输出1，2，3一直到最大的n位整数。
 * 递归解法
 */
public class Print1ToMaxOfNDigits {
    
    public void print1ToMaxOfNDigits(int n) {
        char number[] = new char[n];
        for (int i=0; i<n; i++) {
            number[i] = '0';
        }
        
        printRecursive(number, number.length, 0);
    }
    
    public void printRecursive(char number[], int length, int index) {
        if (index == length) {
            printNumber(number);
            return;
        }
        
        for (int i=0; i<10; i++) {
            number[index] = (char) (i + '0');
            printRecursive(number, length, index + 1);
        }
    }
    
    public void printNumber(char number[]) {
        int i = 0;
        while (i < number.length && number[i] == '0') {
            i++;
        }
        
        for (int j=i; j<number.length; j++) {
            System.out.print(number[j]);
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        Print1ToMaxOfNDigits tester = new Print1ToMaxOfNDigits();
        tester.print1ToMaxOfNDigits(3);
    }
}
