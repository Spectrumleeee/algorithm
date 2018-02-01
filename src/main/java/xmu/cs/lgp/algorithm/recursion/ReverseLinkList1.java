package xmu.cs.lgp.algorithm.recursion;

import java.util.Random;

import xmu.cs.lgp.algorithm.linkedlist.pojo.LinkedNode;

/**
 * 阿里笔试题：将形式如 1 -> 2 -> 3 -> 4 -> ···的链表交换位置(不能交换值)为：2 -> 1 -> 4 -> 3 -> ···
 * 主要考察点：递归调用
 * 其余考察点：除了思想，语言的规范性，当时做出来但是方法没有加static，注意细节
 */
public class ReverseLinkList1 {

    public static final int LIST_LEN = 10;
    
    public static void main(String[] args) {
        LinkedNode headBeforeTransfer = buildLinkList(LIST_LEN);
        printLinkedList(headBeforeTransfer, "before");
      
        LinkedNode headAfterTransfer = transfer(headBeforeTransfer);
        printLinkedList(headAfterTransfer, "after ");
    }
    
    public static LinkedNode transfer(LinkedNode head) {
        if (head == null) {
            return null;
        }
        // 递归反转节点
        LinkedNode newHead = reverse(head);
        return newHead;
    }
    
    public static LinkedNode reverse(LinkedNode head) {
        // 递归调用结束条件
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        LinkedNode newHead = head.getNext();
        // 递归调用，将第3个节点作为头部节点
        LinkedNode linkedNode = reverse(newHead.getNext());
        // 链接两次递归调用的尾节点和头结点
        head.setNext(linkedNode);
        // 反转当前节点和下一个节点
        newHead.setNext(head);
        
        // 返回新的头部节点  
        return newHead;
    }
    
    public static void printLinkedList(LinkedNode head, String desc) {
        System.out.print(desc + ": ");
        while(head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
    
    public static LinkedNode buildLinkList(int len){
        Random rdm = new Random();
        LinkedNode head = new LinkedNode(0);
        LinkedNode retHead = head;
        for (int i=0; i<len; i++) {
            LinkedNode tmp = new LinkedNode(rdm.nextInt(100));
            head.setNext(tmp);
            head = tmp;
        }
      
        return retHead;
    }
}
