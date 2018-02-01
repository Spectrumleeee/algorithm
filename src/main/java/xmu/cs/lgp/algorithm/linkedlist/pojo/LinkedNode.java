/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-22
 */

package xmu.cs.lgp.algorithm.linkedlist.pojo;

public class LinkedNode {
    private int value;
    private String name;
    private LinkedNode next;

    public LinkedNode() {
        this(-1, null, null);
    }
    
    public LinkedNode(int value) {
        this(value, null, null);
    }
    
    public LinkedNode(String name) {
        this(-1, name, null);
    }
    
    public LinkedNode(int value, String name) {
        this(value, name, null);
    }
    
    public LinkedNode(int value, String name, LinkedNode next) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
