/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.string;
/**
 * 剑指Offer --- 12.输出1，2，3一直到最大的n位整数。
 * 字符串模拟大整数加法
 */
public class Print1ToMaxOfNDigits {
    
    public void print1ToMaxOfNDigits(int n) {
        char number[] = new char[n];
        for (int i=0; i<n; i++) {
            number[i] = '0';
        }
        
        while(!increment(number)) {
            printNumber(number);
        }
    }
    
    public boolean increment(char number[]) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int length = number.length;
        
        for (int i=length -1; i>=0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            
            if (i == length -1) {
                nSum += 1;
            }
            
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) (nSum + '0');
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        
        return isOverflow;
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
