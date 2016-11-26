/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.linkedlist;

import xmu.cs.lgp.algorithm.linkedlist.pojo.LinkedNode;

public class LoopInLinkedList {

    public boolean existLoop(LinkedNode head) {
        if ( head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return false;
        }
        
        LinkedNode slow = head;
        LinkedNode fast = head;
        
        while(slow != null) {
            slow = slow.getNext();
            
            if (fast == null || fast.getNext() == null) {
                return false;
            } else {
                fast = fast.getNext().getNext();
            }
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        LinkedNode head = new LinkedNode();
        LinkedNode headA = new LinkedNode();
        LinkedNode headB = new LinkedNode();
        LinkedNode headC = new LinkedNode();
        LinkedNode headD = new LinkedNode();
        
        head.setNext(headA);
        headA.setNext(headB);
        headB.setNext(headC);
        headC.setNext(headD);
        headD.setNext(headB);
        
        LoopInLinkedList testCase = new LoopInLinkedList();
        System.out.println(testCase.existLoop(head));
    }

}
