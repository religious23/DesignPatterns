package 组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main
 * @description: 组合设计模式
 * @date 2021-11-16
 */
public class Main {
    abstract static class Node {
        abstract void p();
    }

    static class LeafNode extends Node {
        String content;

        public LeafNode(String content) {
            this.content = content;
        }

        @Override
        void p() {
            System.out.println(content);
        }
    }

    static class BranchNode extends Node {
        String content;
        List<Node> nodes = new ArrayList<>();

        public BranchNode(String content) {
            this.content = content;
        }

        void add(Node node) {
            nodes.add(node);
        }

        @Override
        void p() {
            System.out.println(content);
        }
    }

    public static void main(String[] args) {
        BranchNode A = new BranchNode("A");
        BranchNode b = new BranchNode("b");
        BranchNode c = new BranchNode("c");
        BranchNode d = new BranchNode("d");
        LeafNode n1 = new LeafNode("1");
        LeafNode n2 = new LeafNode("2");
        LeafNode n3 =new LeafNode("3");
        LeafNode n4 =new LeafNode("4");
        A.add(b);
        A.add(c);
        A.add(d);
        b.add(n1);
        c.add(n2);
        d.add(n3);
        c.add(n4);
        getTree(A,0);
    }

    static void getTree(Node node,int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.p();
        if(node instanceof BranchNode){
            for (Node node1 : ((BranchNode) node).nodes) {
                getTree(node1,depth+1);
            }
        }
    }
}
