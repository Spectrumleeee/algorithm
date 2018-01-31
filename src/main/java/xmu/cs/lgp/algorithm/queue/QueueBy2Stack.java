/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.queue;

import java.util.Stack;

public class QueueBy2Stack {

    Stack<String> stack1;
    Stack<String> stack2;

    public QueueBy2Stack() {
        stack1 = new Stack<String>();
        stack2 = new Stack<String>();
    }

    public void appendTail(String item) {
        stack1.add(item);
    }

    public String deleteHead() {
        if (stack2.size() == 0) {
            while (stack1.size() > 0) {
                String item = stack1.pop();
                stack2.add(item);
            }
        }
        
        if (stack2.size() == 0) {
            throw new RuntimeException("queue is empty");
        }
        
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueBy2Stack queue = new QueueBy2Stack();
        queue.appendTail("Hello");
        queue.appendTail("welcome");
        queue.appendTail("to");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail("China!");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

}
