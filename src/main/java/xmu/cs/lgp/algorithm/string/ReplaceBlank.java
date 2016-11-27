/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.string;
/**
 * 剑指Offer --- 4.将字符串中空格替换成'%20',替换前'we are happy',替换后'we%20are%20happy'
 * 从后往前替换法，提高算法效率至 O(n)
 */
public class ReplaceBlank {
    
    public char[] replaceBlank(char[] string, int length) {
        if (string == null || length <= 0) {
            return null;
        }
        
        int numberOfBlank = countBlankNumber(string, length);
        int newLength = length + numberOfBlank * 2;
        char[] newString = new char[newLength];
        
        int oldIndex = length -1;
        int newIndex = newLength -1;
        while (oldIndex >= 0 && newIndex >= oldIndex) {
            if (string[oldIndex] != ' ') {
                newString[newIndex--] = string[oldIndex--];
            } else {
                newString[newIndex--] = '0';
                newString[newIndex--] = '2';
                newString[newIndex--] = '%';
                oldIndex--;
            }
        }
        
        return newString;
    }
    
    private int countBlankNumber(char[] string, int length) {
        int numberOfBlank = 0;
        
        for (int i=0; i<length; i++) {
            if (string[i] == ' ') {
                numberOfBlank++;
            }
        }
        
        return numberOfBlank;
    }
    
    public static void main(String[] args) {
        ReplaceBlank tester = new ReplaceBlank();
        char[] stringToReplace = "we are very very very happy!".toCharArray();
        
        char[] stringAfterReplaceBlank = tester.replaceBlank(stringToReplace, stringToReplace.length);
        
        for (int i=0; i<stringAfterReplaceBlank.length; i++) {
            System.out.print(stringAfterReplaceBlank[i]);
        }
    }
}
