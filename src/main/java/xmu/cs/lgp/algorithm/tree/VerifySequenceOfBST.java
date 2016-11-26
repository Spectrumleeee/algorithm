/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.tree;

import java.util.Arrays;

/**
 * verify sequence of Binary Search Tree(BST)
 */
public class VerifySequenceOfBST {
    
    /**
     * verify postorder sequence of BST
     */
    public boolean verifyPostorderSequenceOfBST(int sequence[], int length) {
        if (sequence == null || length <= 0) {
            return false;
        }

        int rootValue = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > rootValue) {
                break;
            }
        }

        int j = i;
        for(; j < length - 1; j++) {
            if (sequence[j] < rootValue) {
                return false;
            }
        }
        
        boolean left = true;
        if (i > 0) {
            left = verifyPostorderSequenceOfBST(sequence, i);
        }

        boolean right = true;
        if (i < length - 1) {
            
            int sequenceRight[] = new int[length - i - 1];
            System.arraycopy(sequence, i, sequenceRight, 0, length - i - 1);
            
            right = verifyPostorderSequenceOfBST(sequenceRight, length - i - 1);
        }
        return (left && right);
    }
    
    public static void main(String[] args) {
        VerifySequenceOfBST testCase = new VerifySequenceOfBST();

        int sequenceYes[] = new int[]{5, 7, 6, 9, 11, 10, 8};
        int sequenceNo[] = new int[]{10, 8, 9};
        boolean resultTrueFalse;
        
        resultTrueFalse = testCase.verifyPostorderSequenceOfBST(sequenceYes, sequenceYes.length);
        System.out.println(Arrays.toString(sequenceYes) + " : " + resultTrueFalse);
        
        resultTrueFalse = testCase.verifyPostorderSequenceOfBST(sequenceNo, sequenceNo.length);
        System.out.println(Arrays.toString(sequenceNo) + " : " + resultTrueFalse);
    }
}
