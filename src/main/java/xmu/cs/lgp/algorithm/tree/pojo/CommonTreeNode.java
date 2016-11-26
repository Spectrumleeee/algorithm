package xmu.cs.lgp.algorithm.tree.pojo;

import java.util.List;

public class CommonTreeNode {
    private int value;
    
    private List<CommonTreeNode> child;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<CommonTreeNode> getChild() {
        return child;
    }

    public void setChild(List<CommonTreeNode> child) {
        this.child = child;
    }
}
