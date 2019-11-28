package xmu.cs.lgp.algorithm.linkedlist.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Des
 * @Author gplee@sina.cn
 * @Date 2019/11/28 16:01
 **/
public class SentenceNode {

    private boolean end = false;

    private Map<String, SentenceNode> next = new HashMap<String, SentenceNode>();

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Map<String, SentenceNode> getNext() {
        return next;
    }

    public void setNext(Map<String, SentenceNode> next) {
        this.next = next;
    }
}
