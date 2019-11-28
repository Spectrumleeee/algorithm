package xmu.cs.lgp.algorithm.linkedlist;

import xmu.cs.lgp.algorithm.linkedlist.pojo.SentenceNode;

/**
 * @Des 判断用户输入的字符串之前是否已经搜索过
 * @Author gplee@sina.cn
 * @Date 2019/11/28 16:00
 **/
public class SentenceExistedBefore {

    private SentenceNode head = new SentenceNode();

    public boolean search(String inStr) {
        boolean rst = false;

        if (inStr == null || inStr.length() == 0) {
            return false;
        }

        SentenceNode currNode = head;
        for (int i=0; i<inStr.length(); i++) {
            String curChar = inStr.charAt(i) + "";

            if (currNode.getNext().containsKey(curChar)) {
                // 包含以当前字符开头的节点，判断当前节点是否是语句的终止节点
                currNode = currNode.getNext().get(curChar);
                if (i == inStr.length()-1 && currNode.isEnd()) {
                    return true;
                } else if (i == inStr.length()-1) {
                    currNode.setEnd(true);
                    return false;
                } else {
                    continue;
                }
            } else {
                // 不包含以当前字符开头的节点，那么就新建一个节点，添加到搜索树中
                SentenceNode node = new SentenceNode();
                if (i == inStr.length()-1) {
                    node.setEnd(true);
                }
                currNode.getNext().put(curChar+"", node);
                currNode = node;
            }
        }

        return rst;
    }

    public static void main(String[] args) {

        SentenceExistedBefore seb = new SentenceExistedBefore();

        System.out.println(seb.search("a"));
        System.out.println(seb.search("b"));
        System.out.println(seb.search("c"));
        System.out.println(seb.search("ab"));
        System.out.println(seb.search("ac"));
        System.out.println(seb.search("abd"));
        System.out.println(seb.search("abe"));
        System.out.println(seb.search("abdf"));
        System.out.println(seb.search("abdh"));
        System.out.println(seb.search("abdg"));
        System.out.println(seb.search("a"));
        System.out.println(seb.search("ab"));
        System.out.println(seb.search("abc"));
        System.out.println(seb.search("abd"));
        System.out.println(seb.search("abdf"));
    }

}
