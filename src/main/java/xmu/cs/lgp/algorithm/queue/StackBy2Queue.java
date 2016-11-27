/**
 * Author:  liguangpu <spectrumleeee@gmail.com>
 * Created: 2016-11-27
 */

package xmu.cs.lgp.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackBy2Queue {
    
    Queue<String> queue1;
    Queue<String> queue2;
    
    public StackBy2Queue() {
        queue1 = new LinkedList<String>();
        queue2 = new LinkedList<String>();
    }
    
    public void add(String item) {
        queue1.add(item);
    }
    
    public String pop() {
        if (queue1.size() == 0) {
            throw new RuntimeException("queue is empty!");
        }
        
        if (queue1.size() == 1) {
            return queue1.poll();
        }
        
        while (queue1.size() > 1) {
            String item = queue1.poll();
            queue2.add(item);
        }
        
        String lastItem = queue1.poll();
        
        while (queue2.size() > 0) {
            queue1.add(queue2.poll());
        }
        
        return lastItem;
    }
    
    public static void main(String[] args) {
        StackBy2Queue stack = new StackBy2Queue();
//        StackByOneQueue stack = new StackByOneQueue();
        stack.add("Hello");
        stack.add("welcome");
        stack.add("to");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.add("China!");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class StackByOneQueue {
    Queue<String> queue;
    
    public StackByOneQueue() {
        queue = new LinkedList<String>();
    }
    
    public void add(String item) {
        queue.add(item);
    }
    
    public String pop() {
        if (queue.size() == 0) {
            throw new RuntimeException("queue is empty!");
        }
        
        if (queue.size() == 1) {
            return queue.poll();
        }
        
        int queueSize = queue.size();
        while (queueSize > 1) {
            queue.add(queue.poll());
            queueSize--;
        }
        
        return queue.poll();
    }
}
