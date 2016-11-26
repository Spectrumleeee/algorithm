/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.linkedlist.pojo;

public class LinkedNode {
    private int value;
    private LinkedNode next;

    public LinkedNode() {
        this(-1, null);
    }
    
    public LinkedNode(int value) {
        this(value, null);
    }
    
    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
